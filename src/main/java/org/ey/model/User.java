package org.pruebaEY.model;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

//import java.time.OffsetDateTime;
import java.util.*;
import javax.persistence.*;



@Entity
@Table(name = "users")
public class User {

    //@Id
    /*
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "primary_sequence"
    )
     */
    //private Long id;
    //@Id
    //@Column(name = "id")
    //@Type(type = "uuid-char")
    //private UUID id;// = UUID.randomUUID();
    //@Id
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(
    //        name = "UUID",
    //        strategy = "org.hibernate.id.UUIDGenerator"
    //)
    //private UUID id;

    //@Id
    //@GeneratedValue(strategy = GenerationType.UUID)
   // private UUID id;

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

    //@Column(nullable = false, unique = true)
    //private String phones;

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