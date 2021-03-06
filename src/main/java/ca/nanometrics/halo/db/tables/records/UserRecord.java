/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables.records;


import ca.nanometrics.halo.db.tables.User;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.time.Instant;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements VertxPojo, Record7<Integer, Integer, String, String, String, Instant, Instant> {

    private static final long serialVersionUID = -1662128581;

    /**
     * Setter for <code>halo.user.user_id</code>.
     */
    public UserRecord setUserId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>halo.user.organization_id</code>.
     */
    public UserRecord setOrganizationId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.organization_id</code>.
     */
    public Integer getOrganizationId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>halo.user.first_name</code>.
     */
    public UserRecord setFirstName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>halo.user.last_name</code>.
     */
    public UserRecord setLastName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.last_name</code>.
     */
    public String getLastName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>halo.user.email</code>.
     */
    public UserRecord setEmail(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>halo.user.created_at</code>.
     */
    public UserRecord setCreatedAt(Instant value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.created_at</code>.
     */
    public Instant getCreatedAt() {
        return (Instant) get(5);
    }

    /**
     * Setter for <code>halo.user.updated_at</code>.
     */
    public UserRecord setUpdatedAt(Instant value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>halo.user.updated_at</code>.
     */
    public Instant getUpdatedAt() {
        return (Instant) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, Instant, Instant> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, Instant, Instant> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return User.USER.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return User.USER.ORGANIZATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User.USER.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return User.USER.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field6() {
        return User.USER.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Instant> field7() {
        return User.USER.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUserId();
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
    public String component3() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component6() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant component7() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUserId();
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
    public String value3() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value6() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instant value7() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(Integer value) {
        setOrganizationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(Instant value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(Instant value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Instant value6, Instant value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer userId, Integer organizationId, String firstName, String lastName, String email, Instant createdAt, Instant updatedAt) {
        super(User.USER);

        set(0, userId);
        set(1, organizationId);
        set(2, firstName);
        set(3, lastName);
        set(4, email);
        set(5, createdAt);
        set(6, updatedAt);
    }

    public UserRecord(io.vertx.core.json.JsonObject json) {
        this();
        fromJson(json);
    }

    @Override
    public UserRecord fromJson(io.vertx.core.json.JsonObject json) {
        setUserId(json.getInteger("user_id"));
        setOrganizationId(json.getInteger("organization_id"));
        setFirstName(json.getString("first_name"));
        setLastName(json.getString("last_name"));
        setEmail(json.getString("email"));
        setCreatedAt(json.getInstant("created_at"));
        setUpdatedAt(json.getInstant("updated_at"));
        return this;
    }


    @Override
    public io.vertx.core.json.JsonObject toJson() {
        io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
        json.put("user_id",getUserId());
        json.put("organization_id",getOrganizationId());
        json.put("first_name",getFirstName());
        json.put("last_name",getLastName());
        json.put("email",getEmail());
        json.put("created_at",getCreatedAt());
        json.put("updated_at",getUpdatedAt());
        return json;
    }

}
