package ca.nanometrics.util.jooq;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

public class JooqEnvironment
{
  private final SQLDialect m_dialect;
  private final String m_database;
  private final String m_host;
  private final String m_username;
  private final String m_password;

  JooqEnvironment(SQLDialect dialect, String database, String host, String username, String password)
  {
    m_dialect = dialect;
    m_database = database;
    m_host = host;
    m_username = username;
    m_password = password;
  }

  public String getDatabase()
  {
    return m_database;
  }

  public String getHost()
  {
    return m_host;
  }

  public String getUsername()
  {
    return m_username;
  }

  public String getPassword()
  {
    return m_password;
  }

  public org.jooq.Configuration build() throws SQLException
  {
    SQLDialect family = m_dialect.family();
    String subprotocol = family == SQLDialect.POSTGRES ? "postgresql" : family.name().toLowerCase();
    Configuration configuration = new DefaultConfiguration().derive(
        DriverManager.getConnection("jdbc:" + subprotocol + "://" + m_host + "/" + m_database, m_username, m_password));
    configuration.set(m_dialect);
    return configuration;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private SQLDialect m_dialect = SQLDialect.POSTGRES;
    private String m_database;
    private String m_host;
    private String m_username;
    private String m_password;

    public JooqEnvironment build()
    {
      return new JooqEnvironment(m_dialect, m_database, m_host, m_username, m_password);
    }

    public Builder dialect(SQLDialect dialect)
    {
      m_dialect = dialect;
      return this;
    }

    public Builder database(String database)
    {
      m_database = database;
      return this;
    }

    public Builder host(String host)
    {
      m_host = host;
      return this;
    }

    public Builder username(String username)
    {
      m_username = username;
      return this;
    }

    public Builder password(String password)
    {
      m_password = password;
      return this;
    }
  }
}
