package org.ey.repository;

import org.ey.model.User;

import java.util.List;

public interface UserDao {

    void persist(User user);

    List<User> findAllUsers();

    List<User> findByEmail(String email);

}