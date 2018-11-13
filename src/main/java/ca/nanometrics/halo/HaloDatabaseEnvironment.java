package ca.nanometrics.halo;

import ca.nanometrics.util.jooq.JooqEnvironment;

public class HaloDatabaseEnvironment
{
  public static final String ENV_DEVELOPMENT = "development";

  private static final String DB_HOST_DEVELOPMENT = "localhost";
  private static final String DB_PASSWORD_DEVELOPMENT = "password";

  private static final String DB_USER = "sa";

  private final String m_prefix;

  public HaloDatabaseEnvironment()
  {
    this("halo");
  }

  public HaloDatabaseEnvironment(String prefix)
  {
    m_prefix = prefix;
  }

  public String getDatabase()
  {
    return m_prefix + "_development";
  }

  public JooqEnvironment build()
  {
    return JooqEnvironment.builder()//
        .database(getDatabase())//
        .host(DB_HOST_DEVELOPMENT)//
        .username(DB_USER)//
        .password(DB_PASSWORD_DEVELOPMENT)//
        .build();
  }
}
