package ca.nanometrics.example.graphql.schema;

public class AssetType
{
  private final ca.nanometrics.halo.db.tables.pojos.AssetType m_pojo;

  AssetType(ca.nanometrics.halo.db.tables.pojos.AssetType pojo)
  {
    m_pojo = pojo;
  }

  public Integer getAssetTypeId()
  {
    return m_pojo.getAssetTypeId();
  }

  public String getAssetTypeName()
  {
    return m_pojo.getAssetTypeName();
  }

}
