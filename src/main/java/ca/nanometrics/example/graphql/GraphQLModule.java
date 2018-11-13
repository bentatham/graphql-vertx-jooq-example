package ca.nanometrics.example.graphql;

import java.sql.SQLException;

import javax.inject.Singleton;

import org.jooq.Record;

import com.google.common.base.CaseFormat;

import ca.nanometrics.example.graphql.assets.Assets;
import ca.nanometrics.example.graphql.assets.AssetsDatabase;
import ca.nanometrics.example.graphql.schema.QueryResolver;
import ca.nanometrics.example.graphql.users.Users;
import ca.nanometrics.example.graphql.users.UsersDatabase;
import ca.nanometrics.halo.HaloDatabaseEnvironment;
import ca.nanometrics.halo.db.tables.pojos.User;
import ca.nanometrics.util.jooq.JooqEnvironment;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import graphql.Scalars;
import graphql.language.Field;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.FieldWiringEnvironment;
import graphql.schema.idl.WiringFactory;
import io.vertx.core.Verticle;
import io.vertx.reactivex.core.Vertx;

@dagger.Module
public class GraphQLModule
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(GraphQLModule.class);

  @Provides
  @IntoMap
  @ClassKey(GraphQLVerticle.class)
  Verticle provideGraphQLVerticle(GraphQLVerticle verticle)
  {
    return verticle;
  }

  @Provides
  Vertx provideVertx()
  {
    return Vertx.vertx();
  }

  @Provides
  @Singleton
  JooqEnvironment providesJooqEnvironment()
  {
    return new HaloDatabaseEnvironment().build();
  }

  @Provides
  public org.jooq.Configuration provideConfiguration(JooqEnvironment environment)
  {
    try
    {
      return environment.build();
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Provides
  Users provideUsers(UsersDatabase users)
  {
    return users;
  }

  @Provides
  Assets provideAssets(AssetsDatabase assets)
  {
    return assets;
  }

  @Provides
  @Singleton
  GraphQLSchema provideGraphQLSchema(QueryResolver query)
  {
    return com.coxautodev.graphql.tools.SchemaParser.newParser()//
        .file("halo-users.graphqls")//
        .resolvers(query)//
        .build().makeExecutableSchema();

    // try (InputStreamReader reader =
    // new InputStreamReader(getClass().getClassLoader().getResourceAsStream("halo-users.graphqls"));)
    // {
    // TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(reader);
    // RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring().type(//
    // TypeRuntimeWiring.newTypeWiring("QueryResolver")
    // .dataFetcher("users", env -> db(env).getUsers(toInteger(env.getArgument("userId")), env.getSelectionSet()))
    // .dataFetcher("organizations",
    // env -> db(env).getOrganizations(toInteger(env.getArgument("organizationId")), env.getSelectionSet()))
    // .dataFetcher("organization",
    // env -> db(env).getOrganizations(toInteger(env.getArgument("organizationId")), env.getSelectionSet()))
    // .dataFetcher("assets",
    // env -> db(env).getAssets(toInteger(env.getArgument("assetId")), env.getSelectionSet())))
    // .wiringFactory(new JooqWiringFactory()).build();
    // return new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
    // }
    // catch (IOException e)
    // {
    // throw new RuntimeException("Failed to load graphql schema", e);
    // }
  }

  private DatabaseAccess db(DataFetchingEnvironment env)
  {
    return ((DatabaseContext) env.getContext()).db();
  }

  GraphQLObjectType createQueryType()
  {
    return GraphQLObjectType.newObject().name("query").build();
  }

  GraphQLObjectType createUserType()
  {
    return GraphQLObjectType.newObject().name("User")//
        .description("One of the users.") //
        .field(GraphQLFieldDefinition.newFieldDefinition().name("firstName").description("First name.")
            .type(Scalars.GraphQLString)//
            .dataFetcher(env -> ((User) env.getSource()).getFirstName())) //
        .field(GraphQLFieldDefinition.newFieldDefinition().name("lastName").description("Last name.")
            .type(Scalars.GraphQLString)//
            .dataFetcher(env -> ((User) env.getSource()).getLastName())) //
        .field(GraphQLFieldDefinition.newFieldDefinition().name("email").description("Email address.")
            .type(Scalars.GraphQLString)//
            .dataFetcher(env -> ((User) env.getSource()).getEmail())) //
        .build();
  }

  private Integer toInteger(Object obj)
  {
    return obj == null ? null : Integer.parseInt(obj.toString());
  }

  final class JooqWiringFactory implements WiringFactory
  {
    @Override
    public DataFetcher< ? > getDefaultDataFetcher(FieldWiringEnvironment environment)
    {
      return env -> {
        Object source = env.getSource();
        if (source == null)
        {
          return null;
        }
        if (source instanceof Record)
        {
          Record record = (Record) source;
          Field field = env.getFields().get(0);
          String dbFieldName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
          if (record.field(dbFieldName) == null)
          {
            LOG.info("No field for {}", dbFieldName);
            return dbFieldName;
          }
          return record.get(dbFieldName);
        }
        return source;
      };
    }
  }
}
