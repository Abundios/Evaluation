package org.ey.repository;

import org.ey.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<User> findByEmail(String email)
    {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u" +
                                 " WHERE u.email = :email",
                                 User.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }

}
