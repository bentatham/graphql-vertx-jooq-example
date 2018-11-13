package ca.nanometrics.example.graphql.schema;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.ImmutableList;

import ca.nanometrics.example.graphql.assets.Assets;
import ca.nanometrics.example.graphql.users.Users;
import io.reactivex.Single;

public class QueryResolver implements GraphQLQueryResolver
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(QueryResolver.class);

  private final Users m_users;
  private final Assets m_assets;

  @Inject
  public QueryResolver(Users users, Assets assets)
  {
    m_users = users;
    m_assets = assets;
  }

  public Future<Organization> organization(int organizationId)
  {
    return m_users.getOrganizationById(organizationId).onErrorReturn(e -> {
      LOG.error("Error getting organization", e);
      return Optional.empty();
    }).map(optional -> optional.map(org -> new Organization(org, m_users, m_assets)).orElse(null))//
        .toFuture();
  }

  public Future<List<Organization>> organizations(List<Integer> organizationIds)
  {
    Single<List<ca.nanometrics.halo.db.tables.pojos.Organization>> result;
    if (organizationIds == null || organizationIds.isEmpty())
    {
      result = m_users.getOrganizations();
    }
    else
    {
      result = m_users.getOrganizationsById(organizationIds);
    }
    Single<List<Organization>> map = result//
        .onErrorReturn(e -> {
          LOG.error("Error getting organizations", e);
          return ImmutableList.of();
        }) //
        .map(orgs -> {
          return orgs.stream().map(org -> new Organization(org, m_users, m_assets)).collect(Collectors.toList());
        });
    return map.toFuture();
  }

  public Future<List<Asset>> assets(int organizationId)
  {
    return m_assets.getAssetsForOrganization(organizationId)
        .map(assets -> assets.stream().map(asset -> new Asset(asset, m_assets)).collect(Collectors.toList()))//
        .toFuture();
  }

  public Future<List<User>> users(int userId)
  {
    return null; // TODO
  }
}
