package com.company.libraryFinal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usr_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lname;

    private String fname;

    private Date dateBirth;

    @OneToOne(mappedBy = "userInfo")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date date_birth) {
        this.dateBirth = dateBirth;
    }

    public UserInfo() {
    }

    public UserInfo(String lname, String fname, Date dateBirth, User user) {
        this.lname = lname;
        this.fname = fname;
        this.dateBirth = dateBirth;
        this.user = user;
    }

}
