/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables.daos;


import ca.nanometrics.halo.db.tables.Asset;
import ca.nanometrics.halo.db.tables.records.AssetRecord;

import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractVertxDAO;

import java.time.Instant;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;


import io.reactivex.Single;
import java.util.Optional;
import io.github.jklingsporn.vertx.jooq.rx.jdbc.JDBCRXQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetDao extends AbstractVertxDAO<AssetRecord, ca.nanometrics.halo.db.tables.pojos.Asset, Integer, Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>>, Single<Optional<ca.nanometrics.halo.db.tables.pojos.Asset>>, Single<Integer>, Single<Integer>> implements io.github.jklingsporn.vertx.jooq.rx.VertxDAO<AssetRecord,ca.nanometrics.halo.db.tables.pojos.Asset,Integer> {

    /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
    public AssetDao(Configuration configuration, io.vertx.reactivex.core.Vertx vertx) {
        super(Asset.ASSET, ca.nanometrics.halo.db.tables.pojos.Asset.class, new JDBCRXQueryExecutor<AssetRecord,ca.nanometrics.halo.db.tables.pojos.Asset,Integer>(configuration,ca.nanometrics.halo.db.tables.pojos.Asset.class,vertx));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(ca.nanometrics.halo.db.tables.pojos.Asset object) {
        return object.getAssetId();
    }

    /**
     * Find records that have <code>organization_id IN (values)</code> asynchronously
     */
    public Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>> findManyByOrganizationId(List<Integer> values) {
        return findManyByCondition(Asset.ASSET.ORGANIZATION_ID.in(values));
    }

    /**
     * Find records that have <code>asset_type_id IN (values)</code> asynchronously
     */
    public Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>> findManyByAssetTypeId(List<Integer> values) {
        return findManyByCondition(Asset.ASSET.ASSET_TYPE_ID.in(values));
    }

    /**
     * Find records that have <code>serial_number IN (values)</code> asynchronously
     */
    public Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>> findManyBySerialNumber(List<Integer> values) {
        return findManyByCondition(Asset.ASSET.SERIAL_NUMBER.in(values));
    }

    /**
     * Find a unique record that has <code>serial_number = value</code> asynchronously
     */
    public Single<Optional<ca.nanometrics.halo.db.tables.pojos.Asset>> findOneBySerialNumber(Integer value) {
        return findOneByCondition(Asset.ASSET.SERIAL_NUMBER.eq(value));
    }

    /**
     * Find records that have <code>created_at IN (values)</code> asynchronously
     */
    public Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>> findManyByCreatedAt(List<Instant> values) {
        return findManyByCondition(Asset.ASSET.CREATED_AT.in(values));
    }

    /**
     * Find records that have <code>updated_at IN (values)</code> asynchronously
     */
    public Single<List<ca.nanometrics.halo.db.tables.pojos.Asset>> findManyByUpdatedAt(List<Instant> values) {
        return findManyByCondition(Asset.ASSET.UPDATED_AT.in(values));
    }

    @Override
    public JDBCRXQueryExecutor<AssetRecord,ca.nanometrics.halo.db.tables.pojos.Asset,Integer> queryExecutor(){
        return (JDBCRXQueryExecutor<AssetRecord,ca.nanometrics.halo.db.tables.pojos.Asset,Integer>) super.queryExecutor();
    }
}
