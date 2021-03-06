/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables.records;


import ca.nanometrics.halo.db.tables.Asset;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.Instant;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class AssetRecord extends UpdatableRecordImpl<AssetRecord> implements VertxPojo, Record6<Integer, Integer, Integer, Integer, Instant, Instant> {

    private static final long serialVersionUID = 394002117;

    /**
     * Setter for <code>halo.asset.asset_id</code>.
     */
    public AssetRecord setAssetId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.asset_id</code>.
     */
    public Integer getAssetId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>halo.asset.organization_id</code>.
     */
    public AssetRecord setOrganizationId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.organization_id</code>.
     */
    public Integer getOrganizationId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>halo.asset.asset_type_id</code>.
     */
    public AssetRecord setAssetTypeId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.asset_type_id</code>.
     */
    public Integer getAssetTypeId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>halo.asset.serial_number</code>.
     */
    public AssetRecord setSerialNumber(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.serial_number</code>.
     */
    public Integer getSerialNumber() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>halo.asset.created_at</code>.
     */
    public AssetRecord setCreatedAt(Instant value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.created_at</code>.
     */
    public Instant getCreatedAt() {
        return (Instant) get(4);
    }

    /**
     * Setter for <code>halo.asset.updated_at</code>.
     */
    public AssetRecord setUpdatedAt(Instant value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>halo.asset.updated_at</code>.
     */
    public Instant getUpdatedAt() {
        return (Instant) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Instant, Instant> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, Integer, Integer, Integer, Instant, Instant> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Asset.ASSET.ASSET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Asset.ASSET.ORGANIZATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Asset.ASSET.ASSET_TYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Asset.ASSET.SERIAL_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field5() {
        return Asset.ASSET.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field6() {
        return Asset.ASSET.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getAssetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getAssetTypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getSerialNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component6() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getAssetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getAssetTypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getSerialNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value5() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value6() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value1(Integer value) {
        setAssetId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value2(Integer value) {
        setOrganizationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value3(Integer value) {
        setAssetTypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value4(Integer value) {
        setSerialNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value5(Instant value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord value6(Instant value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssetRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Instant value5, Instant value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AssetRecord
     */
    public AssetRecord() {
        super(Asset.ASSET);
    }

    /**
     * Create a detached, initialised AssetRecord
     */
    public AssetRecord(Integer assetId, Integer organizationId, Integer assetTypeId, Integer serialNumber, Instant createdAt, Instant updatedAt) {
        super(Asset.ASSET);

        set(0, assetId);
        set(1, organizationId);
        set(2, assetTypeId);
        set(3, serialNumber);
        set(4, createdAt);
        set(5, updatedAt);
    }

    public AssetRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public AssetRecord fromJson(io.vertx.core.json.JsonObject json) {
        setAssetId(json.getInteger("asset_id"));
        setOrganizationId(json.getInteger("organization_id"));
        setAssetTypeId(json.getInteger("asset_type_id"));
        setSerialNumber(json.getInteger("serial_number"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("asset_id",getAssetId());
        json.put("organization_id",getOrganizationId());
        json.put("asset_type_id",getAssetTypeId());
        json.put("serial_number",getSerialNumber());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
