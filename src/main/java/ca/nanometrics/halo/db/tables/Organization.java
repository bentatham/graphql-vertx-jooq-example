/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables;


import ca.nanometrics.halo.db.Halo;
import ca.nanometrics.halo.db.Indexes;
import ca.nanometrics.halo.db.Keys;
import ca.nanometrics.halo.db.tables.records.OrganizationRecord;
import ca.nanometrics.util.jooq.converter.InstantLocalDateTimeConverter;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Organization extends TableImpl<OrganizationRecord> {

    private static final long serialVersionUID = 1466999707;

    /**
     * The reference instance of <code>halo.organization</code>
     */
    public static final Organization ORGANIZATION = new Organization();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrganizationRecord> getRecordType() {
        return OrganizationRecord.class;
    }

    /**
     * The column <code>halo.organization.organization_id</code>.
     */
    public final TableField<OrganizationRecord, Integer> ORGANIZATION_ID = createField("organization_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('halo.organization_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>halo.organization.organization_name</code>.
     */
    public final TableField<OrganizationRecord, String> ORGANIZATION_NAME = createField("organization_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>halo.organization.created_at</code>.
     */
    public final TableField<OrganizationRecord, Instant> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "", new InstantLocalDateTimeConverter());

    /**
     * The column <code>halo.organization.updated_at</code>.
     */
    public final TableField<OrganizationRecord, Instant> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "", new InstantLocalDateTimeConverter());

    /**
     * Create a <code>halo.organization</code> table reference
     */
    public Organization() {
        this(DSL.name("organization"), null);
    }

    /**
     * Create an aliased <code>halo.organization</code> table reference
     */
    public Organization(String alias) {
        this(DSL.name(alias), ORGANIZATION);
    }

    /**
     * Create an aliased <code>halo.organization</code> table reference
     */
    public Organization(Name alias) {
        this(alias, ORGANIZATION);
    }

    private Organization(Name alias, Table<OrganizationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Organization(Name alias, Table<OrganizationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Organization(Table<O> child, ForeignKey<O, OrganizationRecord> key) {
        super(child, key, ORGANIZATION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Halo.HALO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ORGANIZATION_ORGANIZATION_NAME_KEY, Indexes.ORGANIZATION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OrganizationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORGANIZATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OrganizationRecord> getPrimaryKey() {
        return Keys.ORGANIZATION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OrganizationRecord>> getKeys() {
        return Arrays.<UniqueKey<OrganizationRecord>>asList(Keys.ORGANIZATION_PKEY, Keys.ORGANIZATION_ORGANIZATION_NAME_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization as(String alias) {
        return new Organization(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization as(Name alias) {
        return new Organization(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Organization rename(String name) {
        return new Organization(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organization rename(Name name) {
        return new Organization(name, null);
    }
}
