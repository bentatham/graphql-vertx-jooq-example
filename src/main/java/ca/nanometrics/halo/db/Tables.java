/*
 * This file is generated by jOOQ.
 */
package ca.nanometrics.halo.db;

import javax.annotation.Generated;

import ca.nanometrics.halo.db.tables.Asset;
import ca.nanometrics.halo.db.tables.AssetType;
import ca.nanometrics.halo.db.tables.Organization;
import ca.nanometrics.halo.db.tables.User;

/**
 * Convenience access to all tables in halo
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.11.7" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables
{

  /**
   * The table <code>halo.asset</code>.
   */
  public static final Asset ASSET = ca.nanometrics.halo.db.tables.Asset.ASSET;

  /**
   * The table <code>halo.asset_type</code>.
   */
  public static final AssetType ASSET_TYPE = ca.nanometrics.halo.db.tables.AssetType.ASSET_TYPE;

  /**
   * The table <code>halo.organization</code>.
   */
  public static final Organization ORGANIZATION = ca.nanometrics.halo.db.tables.Organization.ORGANIZATION;

  /**
   * The table <code>halo.user</code>.
   */
  public static final User USER = ca.nanometrics.halo.db.tables.User.USER;
}
