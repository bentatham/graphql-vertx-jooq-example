package ca.nanometrics.example.graphql.schema;

import ca.nanometrics.example.graphql.assets.Assets;

public class Asset
{
  private final ca.nanometrics.halo.db.tables.pojos.Asset m_pojo;
  private final Assets m_assets;

  public Asset(ca.nanometrics.halo.db.tables.pojos.Asset pojo, Assets assets)
  {
    m_pojo = pojo;
    m_assets = assets;
  }

  public int getAssetId()
  {
    return m_pojo.getAssetId();
  }

  public int getOrganizationId()
  {
    return m_pojo.getOrganizationId();
  }

  public int getAssetTypeId()
  {
    return m_pojo.getAssetTypeId();
  }

  public int getSerialNumber()
  {
    return m_pojo.getSerialNumber();
  }

  public AssetType getAssetType()
  {
    return new AssetType(m_assets.getAssetType(m_pojo.getAssetTypeId()).blockingGet().get());
  }
}
