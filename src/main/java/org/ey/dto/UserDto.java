package org.pruebaEY.dto;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pruebaEY.model.Phone;
import org.pruebaEY.model.User;

public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date createddate;
    private Date modifieddate;
    private Date lastlogon;
    private String token;
    private Boolean isactive;

    List<PhoneDto> phones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public void setLastlogon(Date lastlogon) {
        this.lastlogon = lastlogon;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public Date getLastlogon() {
        return lastlogon;
    }

    public String getToken() {
        return token;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public static UserDto fromDaoToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setCreateddate(user.getCreateddate());
        userDto.setModifieddate(user.getModifieddate());
        userDto.setLastlogon(user.getLastlogon());
        userDto.setIsactive(user.getIsactive());
        List<PhoneDto> listPhonesDto = new ArrayList<>();
        List<Phone> listPhones = user.getPhones();
        for (Phone phone:listPhones) {
            PhoneDto phoneDto = new PhoneDto();
            phoneDto.setCitycode(phone.getCitycode());
            phoneDto.setContrycode(phone.getCountrycode());
            phoneDto.setNumber(phone.getNumber());
            listPhonesDto.add(phoneDto);
        }
        userDto.setPhones(listPhonesDto);
        return userDto;
    }

    //public List<String> getPhones() {
    //    return phones;
    //}

    //public void setPhones(List<String> phones) {
    //    this.phones = phones;
    //}
}
