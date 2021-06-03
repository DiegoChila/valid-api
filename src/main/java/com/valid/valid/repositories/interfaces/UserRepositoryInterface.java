package com.valid.valid.repositories.interfaces;

import com.valid.valid.models.entity.User;

import java.util.List;

public interface UserRepositoryInterface {
    List<User> getAll();
    User save(User user);
    boolean existsById(Long id);
    User getById(Long id);
}
