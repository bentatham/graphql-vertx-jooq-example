package ca.nanometrics.example.graphql.schema;

import java.util.Optional;
import java.util.concurrent.Future;

import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import ca.nanometrics.example.graphql.assets.Assets;
import ca.nanometrics.example.graphql.users.Users;

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
}
