package ca.nanometrics.example.graphql.assets;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

import ca.nanometrics.halo.db.tables.daos.AssetDao;
import ca.nanometrics.halo.db.tables.daos.AssetTypeDao;
import ca.nanometrics.halo.db.tables.pojos.Asset;
import ca.nanometrics.halo.db.tables.pojos.AssetType;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class AssetsDatabase implements Assets
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AssetsDatabase.class);

  private final AssetDao m_assetDao;
  private final AssetTypeDao m_assetTypeDao;

  @Inject
  public AssetsDatabase(Vertx vertx, org.jooq.Configuration jooqConfiguration)
  {
    m_assetDao = new AssetDao(jooqConfiguration, vertx);
    m_assetTypeDao = new AssetTypeDao(jooqConfiguration, vertx);
  }

  @Override
  public Single<Boolean> create(Asset asset)
  {
    return m_assetDao.insert(asset).map(count -> count == 1);
  }

  @Override
  public Single<Boolean> delete(Integer id)
  {
    return m_assetDao.deleteById(id).map(count -> count == 1);
  }

  @Override
  public Single<Boolean> update(Asset asset)
  {
    return m_assetDao.update(asset).map(count -> count == 1);
  }

  @Override
  public Single<Optional<AssetType>> getAssetType(Integer id)
  {
    return m_assetTypeDao.findOneById(id);
  }

  @Override
  public Single<List<AssetType>> getAssetsTypes()
  {
    return m_assetTypeDao.findAll();
  }

  @Override
  public Single<Optional<Asset>> getAssetById(int assetId)
  {
    return m_assetDao.findOneById(assetId);
  }

  @Override
  public Single<Optional<Asset>> getAssetBySerialNumber(int serialNumber)
  {
    return m_assetDao.findOneBySerialNumber(serialNumber);
  }

  @Override
  public Single<List<Asset>> getAssetsForOrganization(Integer organizationId)
  {
    return m_assetDao.findManyByOrganizationId(ImmutableList.of(organizationId));
  }

  @Override
  public Single<List<Asset>> getAssetsByType(Integer assetTypeId)
  {
    return m_assetDao.findManyByAssetTypeId(ImmutableList.of(assetTypeId));
  }

  @Override
  public Single<Optional<AssetType>> getAssetTypeByName(String name)
  {
    return m_assetTypeDao.findOneByAssetTypeName(name);
  }

  @Override
  public Single<Boolean> createAssetType(AssetType type)
  {
    return m_assetTypeDao.insert(type).map(count -> count == 1);
  }
}
