package com.company.libraryFinal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lname;

    private String fname;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    private Date dateBirth;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Author() {
    }

    public Author(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;

    }

    public Author(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                ", books=" + books +
                ", dateBirth=" + dateBirth +
                '}';
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
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

    public List<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<>();
        }
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
