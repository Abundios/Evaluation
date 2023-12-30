package org.pruebaEY.repository;

import java.util.List;

import org.pruebaEY.model.User;

//public interface UserRepository extends JpaRepository<User, Long> {
//public interface UserRepository extends CrudRepository<User, Long> {
public interface UserDao {

    void persist(User user);

    List<User> findAllUsers();

    List<User> findByEmail(String email);

}