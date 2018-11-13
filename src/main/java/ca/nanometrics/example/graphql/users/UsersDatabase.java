package ca.nanometrics.example.graphql.users;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.collect.ImmutableList;

import ca.nanometrics.halo.db.tables.daos.OrganizationDao;
import ca.nanometrics.halo.db.tables.daos.UserDao;
import ca.nanometrics.halo.db.tables.pojos.Organization;
import ca.nanometrics.halo.db.tables.pojos.User;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class UsersDatabase implements Users
{
  private final UserDao m_userDao;
  private final OrganizationDao m_organizationDao;

  @Inject
  public UsersDatabase(Vertx vertx, org.jooq.Configuration jooqConfiguration)
  {
    m_userDao = new UserDao(jooqConfiguration, vertx);
    m_organizationDao = new OrganizationDao(jooqConfiguration, vertx);
  }

  @Override
  public Single<List<User>> getUsers()
  {
    return m_userDao.findAll();
  }

  @Override
  public Single<List<User>> getUsersForOrganization(int organizationId)
  {
    return m_userDao.findManyByOrganizationId(ImmutableList.of(organizationId));
  }

  @Override
  public Single<Optional<Organization>> getOrganizationById(int organizationId)
  {
    return m_organizationDao.findOneById(organizationId);
  }

  @Override
  public Single<List<Organization>> getOrganizationsById(List<Integer> organizationIds)
  {
    return m_organizationDao.findManyByIds(organizationIds);
  }

  @Override
  public Single<List<Organization>> getOrganizations()
  {
    return m_organizationDao.findAll();
  }

  @Override
  public Single<Optional<User>> getById(Integer id)
  {
    return m_userDao.findOneById(id);
  }

  @Override
  public Single<Optional<User>> getByEmail(String email)
  {
    return m_userDao.findOneByEmail(email);
  }

  @Override
  public Single<Optional<Organization>> getOrganizationForUser(String userEmail)
  {
    return m_userDao.findOneByEmail(userEmail).flatMap(optional -> optional//
        .map(user -> m_organizationDao.findOneById(user.getOrganizationId()))//
        .orElse(Single.just(Optional.empty())));
  }

  @Override
  public Single<Boolean> create(User user)
  {
    return m_userDao.insert(user).map(count -> count == 1);
  }

  @Override
  public Single<Boolean> delete(Integer id)
  {
    return m_userDao.deleteById(id).map(count -> count == 1);
  }

  @Override
  public Single<Boolean> update(User user)
  {
    return m_userDao.update(user).map(count -> count == 1);
  }

  @Override
  public Single<Optional<User>> getOrCreateUserAndOrganization(User user, String organizationName)
  {
    return m_userDao.findOneByEmail(user.getEmail()).flatMap(existingUser -> existingUser.map(u -> {
      // TODO verify fields and organization
      return Single.just(Optional.of(u));
    }).orElseGet(() -> {
      return getOrCreateOrganization(new Organization().setOrganizationName(organizationName)).flatMap(org -> {
        return createUserWithOrganization(user, org.get());
      });
    }));
  }

  private Single<Optional<User>> createUserWithOrganization(User user, Organization organization)
  {
    return create(user.setOrganizationId(organization.getOrganizationId()))
        .flatMap(success -> success ? m_userDao.findOneByEmail(user.getEmail()) : Single.just(Optional.empty()));
  }

  @Override
  public Single<Optional<Organization>> getOrCreateOrganization(Organization organization)
  {
    return m_organizationDao.findOneByOrganizationName(organization.getOrganizationName())//
        .flatMap((Optional<Organization> existing) -> //
        existing.map(o -> Single.just(Optional.of(o)))//
            .orElseGet(() -> m_organizationDao.insert(organization).flatMap(count -> {
              if (count == 1)
              {
                return m_organizationDao.findOneByOrganizationName(organization.getOrganizationName());
              }
              throw new IllegalStateException("failed to create organization: " + organization.getOrganizationName());
            })));
  }
}
