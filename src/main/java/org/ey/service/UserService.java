package org.pruebaEY.service;

//import org.pruebaEY.model.EntityManagerUtil;
import org.pruebaEY.controller.ResponseHandler;
import org.pruebaEY.dto.PhoneDto;
import org.pruebaEY.dto.UserDto;
import org.pruebaEY.model.Phone;
import org.pruebaEY.model.User;
import org.pruebaEY.repository.UserDAOI;
import org.pruebaEY.repository.UserDao;
import org.pruebaEY.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

//import javax.persistence.EntityManager;

//@EnableJpaRepositories("org.pruebaEY.repository")
///@EnableJpaRepositories("org.pruebaEY.*")
//@EnableJpaRepositories(basePackages="org.pruebaEY.*")
//@EnableJpaRepositories(basePackages="org.pruebaEY.repository", entityManagerFactoryRef="entityManagerFactory")
//@EnableJpaRepositories(basePackages="org.pruebaEY.repository")
//@EnableJpaRepositories("org.pruebaEY.repository")
@Service
public class UserService {
    //private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    //private final UserDao userDao;
    //@Autowired
    //UserDao userDao;
    /*
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("com.huongdanjava.springdatajpa.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:file:data/mydb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }
    @Bean
    public TransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }
    */
    //@Autowired
    //UserDAOI userDao;

    //@Autowired
    //UserDaoImpl userDao;

    final UserDao userDao = null;

    public UserService(/*UserDAOI userDao*/) {
        //this.userDao = userDao;
        //ApplicationContext ctx = new ClassPathXmlApplicationContext(
        //        "spring.xml");
        //userDao = (UserDao) ctx.getBean("userManagerImpl");
    }

    public Long create(User user) {
        //return userRepository.save(user).getId();
        return null;
    }

    @Transactional
    public ResponseEntity<Object> createUser(UserDto userDto) {
        try {
            boolean validPassword = Pattern.compile("^([A-Z]{1}+[a-z]{1,}[0-9]{2})$")
                    .matcher(userDto.getPassword())
                    .matches();
            if (!validPassword) {
                return ResponseHandler.generateResponse("Password no válida",
                        HttpStatus.ACCEPTED, userDto);
            }
            boolean validEmail = Pattern.compile("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.cl)$")
                    .matcher(userDto.getEmail())
                    .matches();
            if (!validEmail) {
                return ResponseHandler.generateResponse("Email no válido",
                        HttpStatus.ACCEPTED, userDto);
            }

            List<User> usersWithEmail = this.findByEmail(userDto.getEmail());
            if (!usersWithEmail.isEmpty()) {
                return ResponseHandler.generateResponse("El correo ya registrado",
                        HttpStatus.ACCEPTED, userDto);
            }


            User user = new User();
            //UUID id = UUID.randomUUID();
            //user.setId(id);
            //user.setId(new Integer(2));
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            LocalDate localDate = LocalDate.now();
            user.setCreateddate(
                    Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
            );
            List<PhoneDto> phonesDto = userDto.getPhones();
            List<Phone> phones = new ArrayList<>();
            for (PhoneDto phoneDto : phonesDto) {
                Phone phone = new Phone();
                phone.setNumber(phoneDto.getNumber());
                phone.setCitycode(phoneDto.getCitycode());
                phone.setCountrycode(phoneDto.getContrycode());
                //phoneService.persist(phone);
                phones.add(phone);
            }
            user.setPhones(phones);
            //userService.persist(user);

                /*
                for (PhoneDto phoneDto : phonesDto) {
                    Phone phone = new Phone();
                    phone.setNumber(phoneDto.getNumber());
                    phone.setCitycode(phoneDto.getCitycode());
                    phone.setCountrycode(phoneDto.getContrycode());
                    phoneService.persist(phone);
                }
                */

            //System.out.println("por fin");
            //return ResponseEntity.ok(HttpStatus.OK);

            ApplicationContext ctx = new ClassPathXmlApplicationContext(
                    "spring.xml");
            UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
            userDao.persist(user);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, userDto);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    public List<UserDto> findAllUsers()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
        List<User> users = userDao.findAllUsers();
        List<UserDto> usersDto = new ArrayList<>();
        for (User user: users) {
            usersDto.add(UserDto.fromDaoToDto(user));
        }
        return usersDto;
        //return userDao.findAllUsers();
    }

    public List<User> findByEmail(String email)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
        return userDao.findByEmail(email);
    }



}
