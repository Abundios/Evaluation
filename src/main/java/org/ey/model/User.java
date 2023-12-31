package org.ey.model;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

//import java.time.OffsetDateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false, unique = true)
    private Date createddate;

    @Column(nullable = false, unique = true)
    private Date modifieddate;

    @Column(nullable = false, unique = true)
    private Date lastlogon;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false, unique = true)
    private Boolean isactive;

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Date getLastlogon() {
        return lastlogon;
    }

    public void setLastlogon(Date lastlogon) {
        this.lastlogon = lastlogon;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }
//@OneToMany(cascade = CascadeType.ALL,
    //        fetch = FetchType.LAZY,
    //        mappedBy = "userId")
    //@JsonManagedReference
    //List<Phone> phones;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    List < Phone > phones = new ArrayList< >();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}