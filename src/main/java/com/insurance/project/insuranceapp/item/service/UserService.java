package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {

    void addUser(User user);

    Map<Long, User> findAllUsers();

    User findById(long id);

    Optional<User> findUserById(long id);

}
