package ca.nanometrics.example.graphql.users;

import java.util.List;
import java.util.Optional;

import ca.nanometrics.halo.db.tables.pojos.Organization;
import ca.nanometrics.halo.db.tables.pojos.User;
import io.reactivex.Single;

public interface Users
{
  Single<Boolean> create(User user);

  Single<Boolean> delete(Integer id);

  Single<Boolean> update(User user);

  Single<Optional<User>> getById(Integer id);

  Single<Optional<User>> getByEmail(String email);

  Single<Optional<Organization>> getOrganizationForUser(String userEmail);

  Single<Optional<User>> getOrCreateUserAndOrganization(User user, String organizationName);

  Single<Optional<Organization>> getOrCreateOrganization(Organization organization);

  Single<List<User>> getUsers();

  Single<List<User>> getUsersForOrganization(int organizationId);

  Single<Optional<Organization>> getOrganizationById(int organizationId);

  Single<List<Organization>> getOrganizationsById(List<Integer> organizationIds);

  Single<List<Organization>> getOrganizations();
}
