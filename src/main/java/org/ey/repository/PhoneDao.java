package org.ey.repository;

import org.ey.model.Phone;

import java.util.List;

public interface PhoneDao {

    void persist(Phone phone);

    List<Phone> findAllPhones();
}
