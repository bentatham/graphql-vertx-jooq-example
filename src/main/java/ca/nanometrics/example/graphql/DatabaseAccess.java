package ca.nanometrics.example.graphql;

import static ca.nanometrics.halo.db.Tables.ASSET;
import static ca.nanometrics.halo.db.Tables.ORGANIZATION;
import static ca.nanometrics.halo.db.Tables.USER;

import java.sql.SQLException;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Select;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;

import ca.nanometrics.util.jooq.JooqEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;

@Singleton
public class DatabaseAccess
{
  private final JooqEnvironment m_environment;

  @Inject
  public DatabaseAccess(JooqEnvironment environment)
  {
    m_environment = environment;
  }

  public Result<Record> getAssets(Integer assetId, DataFetchingFieldSelectionSet fieldSelectionSet)
  {
    return get(jooq -> {
      if (assetId != null)
      {
        return jooq.select().from(ASSET).where(ASSET.ASSET_ID.eq(assetId));
      }
      return jooq.select().from(ASSET);
    });
  }

  public Result<Record> getUsers(Integer userId, DataFetchingFieldSelectionSet fieldSelectionSet)
  {
    return get(jooq -> {
      if (userId != null)
      {
        return jooq.select().from(USER).where(USER.USER_ID.eq(userId));
      }
      if (fieldSelectionSet.contains("organization"))
      {
        return jooq.select()//
            .from(USER//
                .join(ORGANIZATION) //
                .on(ORGANIZATION.ORGANIZATION_ID.eq(USER.ORGANIZATION_ID)));
      }
      return jooq.select().from(USER);
    });
  }

  public Result<Record> getOrganizations(Integer organizationId, DataFetchingFieldSelectionSet fieldSelectionSet)
  {
    return get(jooq -> {
      if (fieldSelectionSet.contains("assets"))
      {
        SelectOnConditionStep<Record> select = jooq //
            .select(ORGANIZATION.fields()) //
            .select(ASSET.fields()) //
            .from(ORGANIZATION) //
            .join(ASSET).on(ORGANIZATION.ORGANIZATION_ID.eq(ASSET.ORGANIZATION_ID)); //
        if (organizationId != null)
        {
          select.where(ORGANIZATION.ORGANIZATION_ID.eq(organizationId));
        }
        return select;
      }
      if (organizationId != null)
      {
        return jooq.select().from(ORGANIZATION).where(ORGANIZATION.ORGANIZATION_ID.eq(organizationId));
      }
      return jooq.select().from(USER.join(ORGANIZATION)//
          .on(ORGANIZATION.ORGANIZATION_ID.eq(USER.ORGANIZATION_ID)));
    });
  }

  public Result<Record> get(Function<DSLContext, Select<Record>> select)
  {
    try (DSLContext jooq = jooq(); Select<Record> sql = select.apply(jooq))
    {
      return sql.fetch();
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }

  DSLContext jooq() throws SQLException
  {
    return DSL.using(m_environment.build());
  }
}
