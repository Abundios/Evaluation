package org.ey.service;


import org.ey.controller.ResponseHandler;
import org.ey.dto.PhoneDto;
import org.ey.dto.UserDto;
import org.ey.dto.UserInfoDto;
import org.ey.model.Phone;
import org.ey.model.User;
import org.ey.repository.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

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

            ApplicationContext ctx = new ClassPathXmlApplicationContext(
                    "spring.xml");
            UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
            userDao.persist(user);

            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(user.getId());
            userInfoDto.setCreateddate(user.getCreateddate());
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, userInfoDto);
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
    }

    public List<User> findByEmail(String email)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
        return userDao.findByEmail(email);
    }



}
