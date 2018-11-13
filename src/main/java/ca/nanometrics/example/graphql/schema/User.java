package ca.nanometrics.example.graphql.schema;

public class User
{
  private final ca.nanometrics.halo.db.tables.pojos.User m_pojo;

  User(ca.nanometrics.halo.db.tables.pojos.User pojo)
  {
    m_pojo = pojo;
  }

  public int getUserId()
  {
    return m_pojo.getUserId();
  }

  public Integer getOrganizationId()
  {
    return m_pojo.getOrganizationId();
  }

  public String getFirstName()
  {
    return m_pojo.getFirstName();
  }

  public String getLastName()
  {
    return m_pojo.getLastName();
  }

  public String getEmail()
  {
    return m_pojo.getEmail();
  }
}
