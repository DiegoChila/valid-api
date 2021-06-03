package com.valid.valid.repositories.crudRepositories;

import com.valid.valid.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {
}
