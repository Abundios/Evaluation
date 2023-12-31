package org.ey.service;

import org.ey.model.Phone;
import org.ey.repository.PhoneDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneService {

    public PhoneService() {
    }

    public Long create(Phone phone) {
        return null;
    }

    @Transactional
    public void persist(final Phone phone) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");
        PhoneDao phoneDao = (PhoneDao) ctx.getBean("phoneDaoImpl");
        phoneDao.persist(phone);

    }

}
