package com.valid.valid.repositories.classes;

import com.valid.valid.models.entity.User;
import com.valid.valid.repositories.crudRepositories.UserCrudRepository;
import com.valid.valid.repositories.interfaces.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public boolean existsById(Long id) {
        return userCrudRepository.existsById(id);
    }

    @Override
    public User getById(Long id) {
        return userCrudRepository.findById(id).orElse(null);
    }
}
