package org.ey.repository;

import org.ey.model.Phone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PhoneDaoImpl implements PhoneDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Phone> findAllPhones() {
        return null;
    }

    @Override
    @Transactional
    public void persist(Phone phone) {
        entityManager.persist(phone);
    }

}
