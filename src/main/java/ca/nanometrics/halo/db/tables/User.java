/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db.tables;

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

import ca.nanometrics.halo.db.Halo;
import ca.nanometrics.halo.db.Indexes;
import ca.nanometrics.halo.db.Keys;
import ca.nanometrics.halo.db.tables.records.UserRecord;
import ca.nanometrics.util.jooq.converter.InstantLocalDateTimeConverter;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.11.7" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord>
{

  private static final long serialVersionUID = -119785230;

  /**
   * The reference instance of <code>halo.user</code>
   */
  public static final User USER = new User();

  /**
   * The class holding records for this type
   */
  @Override
  public Class<UserRecord> getRecordType()
  {
    return UserRecord.class;
  }

  /**
   * The column <code>halo.user.user_id</code>.
   */
  public final TableField<UserRecord, Integer> USER_ID = createField("user_id",
      org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(
          org.jooq.impl.DSL.field("nextval('halo.user_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)),
      this, "");

  /**
   * The column <code>halo.user.organization_id</code>.
   */
  public final TableField<UserRecord, Integer> ORGANIZATION_ID =
      createField("organization_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

  /**
   * The column <code>halo.user.first_name</code>.
   */
  public final TableField<UserRecord, String> FIRST_NAME =
      createField("first_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

  /**
   * The column <code>halo.user.last_name</code>.
   */
  public final TableField<UserRecord, String> LAST_NAME =
      createField("last_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

  /**
   * The column <code>halo.user.email</code>.
   */
  public final TableField<UserRecord, String> EMAIL =
      createField("email", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

  /**
   * The column <code>halo.user.created_at</code>.
   */
  public final TableField<UserRecord, Instant> CREATED_AT = createField("created_at",
      org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false)
          .defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)),
      this, "", new InstantLocalDateTimeConverter());

  /**
   * The column <code>halo.user.updated_at</code>.
   */
  public final TableField<UserRecord, Instant> UPDATED_AT = createField("updated_at",
      org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false)
          .defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.LOCALDATETIME)),
      this, "", new InstantLocalDateTimeConverter());

  /**
   * Create a <code>halo.user</code> table reference
   */
  public User()
  {
    this(DSL.name("user"), null);
  }

  /**
   * Create an aliased <code>halo.user</code> table reference
   */
  public User(String alias)
  {
    this(DSL.name(alias), USER);
  }

  /**
   * Create an aliased <code>halo.user</code> table reference
   */
  public User(Name alias)
  {
    this(alias, USER);
  }

  private User(Name alias, Table<UserRecord> aliased)
  {
    this(alias, aliased, null);
  }

  private User(Name alias, Table<UserRecord> aliased, Field< ? >[] parameters)
  {
    super(alias, null, aliased, parameters, DSL.comment(""));
  }

  public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key)
  {
    super(child, key, USER);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Schema getSchema()
  {
    return Halo.HALO;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Index> getIndexes()
  {
    return Arrays.<Index> asList(Indexes.USER_EMAIL_KEY, Indexes.USER_PKEY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Identity<UserRecord, Integer> getIdentity()
  {
    return Keys.IDENTITY_USER;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public UniqueKey<UserRecord> getPrimaryKey()
  {
    return Keys.USER_PKEY;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<UniqueKey<UserRecord>> getKeys()
  {
    return Arrays.<UniqueKey<UserRecord>> asList(Keys.USER_PKEY, Keys.USER_EMAIL_KEY);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User as(String alias)
  {
    return new User(DSL.name(alias), this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User as(Name alias)
  {
    return new User(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public User rename(String name)
  {
    return new User(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public User rename(Name name)
  {
    return new User(name, null);
  }
}
