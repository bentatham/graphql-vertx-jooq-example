package ca.nanometrics.example.graphql;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import com.coxautodev.graphql.tools.SchemaParserOptions;

import ca.nanometrics.example.graphql.assets.Assets;
import ca.nanometrics.example.graphql.schema.QueryResolver;
import ca.nanometrics.example.graphql.users.Users;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.reactivex.Single;
import io.reactivex.internal.observers.FutureSingleObserver;

public class GraphQLModuleTest
{

  @Test
  public void futureSucceeds()
  {
    Users users = mock(Users.class);
    Assets assets = mock(Assets.class);
    expect(users.getOrganizationById(20)).andReturn(Single.just(Optional.empty()));
    replay(users, assets);
    QueryResolver query = new QueryResolver(users, assets);

    // GraphQLSchema schema = DaggerGraphQLModuleTest_Component.create().schema();
    SchemaParserOptions options = SchemaParserOptions.newOptions()
        .genericWrappers(new SchemaParserOptions.GenericWrapper(FutureSingleObserver.class, 0)).build();
    GraphQLSchema schema = com.coxautodev.graphql.tools.SchemaParser.newParser()//
        .file("halo-users.graphqls")//
        .resolvers(query)//
        .options(options)//
        .build().makeExecutableSchema();

    GraphQL gql = GraphQL.newGraphQL(schema).queryExecutionStrategy(new AsyncExecutionStrategy()).build();
    assertNoGraphQlErrors(gql, new HashMap<>(), new Object(),
        "query { organization(organizationId: 20) { organizationName } }");
  }

  private static void assertNoGraphQlErrors(GraphQL gql, Map<String, Object> args, Object context, String query)
  {
    ExecutionResult result = gql.execute(ExecutionInput.newExecutionInput() //
        .query(query) //
        .context(context) //
        .root(context) //
        .variables(args));
    assertThat(result.getErrors(), is(empty()));
  }
}
