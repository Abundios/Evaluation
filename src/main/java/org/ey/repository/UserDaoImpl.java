package org.pruebaEY.repository;

import org.pruebaEY.model.User;
import org.pruebaEY.repository.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    //private EntityManager entityManager;

    //User findByForename(String forename);

    //User findByUid(String uid);

    //@Override
    //public List<User> findAll(Long id) {System.out.println("feo");return null;}

    //@Override
    //public List<User> findAll() {}

    /*
    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    */

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllUsers() {
        //CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CriteriaQuery<User> cq = builder.createQuery(User.class);
        //Root<User> root = cq.from(User.class);
        //cq.select(root);
        //return entityManager.createQuery(cq).getResultList();
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

    //@Override
    //@Transactional
    //public List<User> findAll()
    //{
    //    TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
    //    return query.getResultList();
    //}

}
