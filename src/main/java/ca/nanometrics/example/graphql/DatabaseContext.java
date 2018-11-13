package ca.nanometrics.example.graphql;

import javax.inject.Inject;

import org.dataloader.DataLoaderRegistry;

/**
 * The context object is passed to each level of a graphql query and in this case it contains the data loader registry.
 * This allows us to keep our data loaders per request since they cache data and cross request caches are often not what
 * you want.
 */
public class DatabaseContext
{
  final DataLoaderRegistry m_dataLoaderRegistry;
  final DatabaseAccess m_db;

  @Inject
  public DatabaseContext(DatabaseAccess databaseAccess)
  {
    m_db = databaseAccess;
    m_dataLoaderRegistry = new DataLoaderRegistry();
  }

  public DataLoaderRegistry getDataLoaderRegistry()
  {
    return m_dataLoaderRegistry;
  }

  public DatabaseAccess db()
  {
    return m_db;
  }
}
