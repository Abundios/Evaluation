package org.pruebaEY.dto;

import java.util.Date;
import java.util.List;

public class UserInfoDto {

    private String name;
    private String email;
    private String password;
    private Date createddate;
    private Date modifieddate;
    private Date lastlogon;
    private String token;
    private Boolean isactive;

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

}
