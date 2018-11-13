package ca.nanometrics.example.graphql.users;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import ca.nanometrics.halo.db.tables.daos.OrganizationDao;
import ca.nanometrics.halo.db.tables.pojos.Organization;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

public class OrganizationsDatabase implements Organizations
{
  static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(OrganizationsDatabase.class);

  private final OrganizationDao m_organizationDao;

  @Inject
  public OrganizationsDatabase(Vertx vertx, org.jooq.Configuration jooqConfiguration)
  {
    m_organizationDao = new OrganizationDao(jooqConfiguration, vertx);
  }

  @Override
  public Single<List<Organization>> getOrganizations()
  {
    return m_organizationDao.findAll();
  }

  @Override
  public Single<Optional<Organization>> getById(Integer id)
  {
    return m_organizationDao.findOneById(id);
  }

  @Override
  public Single<Optional<Organization>> getByName(String name)
  {
    return m_organizationDao.findOneByOrganizationName(name);
  }

  @Override
  public Single<Boolean> delete(Integer id)
  {
    return m_organizationDao.deleteById(id).map(count -> count == 1);
  }

  @Override
  public Single<Boolean> create(Organization organization)
  {
    return m_organizationDao.insert(organization).map(count -> count == 1);
  }
}
