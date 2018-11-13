package ca.nanometrics.example.graphql.assets;

import java.util.List;
import java.util.Optional;

import ca.nanometrics.halo.db.tables.pojos.Asset;
import ca.nanometrics.halo.db.tables.pojos.AssetType;
import io.reactivex.Single;

public interface Assets
{
  Single<Boolean> create(Asset asset);

  Single<Boolean> delete(Integer assetId);

  Single<Boolean> update(Asset asset);

  Single<Optional<Asset>> getAssetById(int assetId);

  Single<Optional<Asset>> getAssetBySerialNumber(int serialNumber);

  Single<List<Asset>> getAssetsForOrganization(Integer organizationId);

  Single<List<Asset>> getAssetsByType(Integer assetTypeId);

  Single<List<AssetType>> getAssetsTypes();

  Single<Optional<AssetType>> getAssetTypeByName(String name);

  Single<Optional<AssetType>> getAssetType(Integer id);

  Single<Boolean> createAssetType(AssetType assetType);
}
