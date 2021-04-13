package com.company.libraryFinal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private String name;
    @Column(name = "year_publishing")
    private Date yearOfPublishing;

    private String description;

    private String genre;

    private boolean status;

    public Storage() {
    }

    public Storage(User user, String name, Date yearOfPublishing, String description, String genre, boolean status) {
        this.user = user;
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.description = description;
        this.genre = genre;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Date publishingDate) {
        this.yearOfPublishing = publishingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
