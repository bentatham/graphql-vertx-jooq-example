/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables.records;


import ca.nanometrics.halo.db.tables.Organization;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.Instant;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class OrganizationRecord extends UpdatableRecordImpl<OrganizationRecord> implements VertxPojo, Record4<Integer, String, Instant, Instant> {

    private static final long serialVersionUID = 522581601;

    /**
     * Setter for <code>halo.organization.organization_id</code>.
     */
    public OrganizationRecord setOrganizationId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>halo.organization.organization_id</code>.
     */
    public Integer getOrganizationId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>halo.organization.organization_name</code>.
     */
    public OrganizationRecord setOrganizationName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>halo.organization.organization_name</code>.
     */
    public String getOrganizationName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>halo.organization.created_at</code>.
     */
    public OrganizationRecord setCreatedAt(Instant value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>halo.organization.created_at</code>.
     */
    public Instant getCreatedAt() {
        return (Instant) get(2);
    }

    /**
     * Setter for <code>halo.organization.updated_at</code>.
     */
    public OrganizationRecord setUpdatedAt(Instant value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>halo.organization.updated_at</code>.
     */
    public Instant getUpdatedAt() {
        return (Instant) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, Instant, Instant> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, Instant, Instant> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Organization.ORGANIZATION.ORGANIZATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Organization.ORGANIZATION.ORGANIZATION_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field3() {
        return Organization.ORGANIZATION.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field4() {
        return Organization.ORGANIZATION.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getOrganizationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component3() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component4() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getOrganizationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getOrganizationName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value3() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value4() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationRecord value1(Integer value) {
        setOrganizationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationRecord value2(String value) {
        setOrganizationName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationRecord value3(Instant value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationRecord value4(Instant value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationRecord values(Integer value1, String value2, Instant value3, Instant value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrganizationRecord
     */
    public OrganizationRecord() {
        super(Organization.ORGANIZATION);
    }

    /**
     * Create a detached, initialised OrganizationRecord
     */
    public OrganizationRecord(Integer organizationId, String organizationName, Instant createdAt, Instant updatedAt) {
        super(Organization.ORGANIZATION);

        set(0, organizationId);
        set(1, organizationName);
        set(2, createdAt);
        set(3, updatedAt);
    }

    public OrganizationRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public OrganizationRecord fromJson(io.vertx.core.json.JsonObject json) {
        setOrganizationId(json.getInteger("organization_id"));
        setOrganizationName(json.getString("organization_name"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("organization_id",getOrganizationId());
        json.put("organization_name",getOrganizationName());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
