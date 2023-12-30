package org.pruebaEY.repository;

import org.pruebaEY.model.Phone;

import java.util.List;

public interface PhoneDao {

    void persist(Phone phone);

    List<Phone> findAllPhones();
}
