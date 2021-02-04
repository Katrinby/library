package com.company.libraryFinal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "books")
    private List<User> users;
    private String publishingHouse;
    @Column(name = "publishing_date")
    private Date publishingDate;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "book_series_id", insertable = false, updatable = false)
    private BookSeries bookSeries;

    @ManyToMany(mappedBy = "books")
    private List<Genre> genre;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Comment> comment;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Mark> mark;

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(Long id, String name, List<User> users, List<Author> authors, BookSeries bookseries, List<Genre> genre) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.authors = authors;
        this.bookSeries = bookseries;
        this.genre = genre;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishing_date) {
        this.publishingDate = publishing_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
