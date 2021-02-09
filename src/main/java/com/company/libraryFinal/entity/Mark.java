package com.company.libraryFinal.entity;

import javax.persistence.*;

@Entity//сделать enum
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    @ManyToOne(targetEntity = User.class)
    private User user;

    private Integer mark;

    public Mark(Integer mark) {
        this.mark = mark;
    }

    public Mark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
