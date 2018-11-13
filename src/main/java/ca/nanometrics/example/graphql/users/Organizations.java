package ca.nanometrics.example.graphql.users;

import java.util.List;
import java.util.Optional;

import ca.nanometrics.halo.db.tables.pojos.Organization;
import io.reactivex.Single;

public interface Organizations
{
  Single<List<Organization>> getOrganizations();

  Single<Boolean> create(Organization organization);

  Single<Boolean> delete(Integer id);

  Single<Optional<Organization>> getById(Integer id);

  Single<Optional<Organization>> getByName(String name);
}
