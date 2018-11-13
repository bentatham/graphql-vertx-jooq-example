package ca.nanometrics.example.graphql.schema;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.stream.Collectors;

import ca.nanometrics.example.graphql.assets.Assets;
import ca.nanometrics.example.graphql.users.Users;

public class Organization
{
  private final Users m_users;
  private final Assets m_assets;
  private final ca.nanometrics.halo.db.tables.pojos.Organization m_pojo;

  Organization(ca.nanometrics.halo.db.tables.pojos.Organization pojo, Users users, Assets assets)
  {
    m_pojo = checkNotNull(pojo);
    m_users = users;
    m_assets = assets;
  }

  public int getOrganizationId()
  {
    return m_pojo.getOrganizationId();
  }

  public String getOrganizationName()
  {
    return m_pojo.getOrganizationName();
  }

  public List<Asset> getAssets()
  {
    return m_assets.getAssetsForOrganization(getOrganizationId()).blockingGet()//
        .stream().map(a -> new Asset(a, m_assets)).collect(Collectors.toList());
  }

  public List<User> getUsers()
  {
    return m_users.getUsersForOrganization(getOrganizationId()).blockingGet()//
        .stream().map(User::new).collect(Collectors.toList());
  }
}
