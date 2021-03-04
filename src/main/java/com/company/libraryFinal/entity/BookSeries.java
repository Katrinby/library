package com.company.libraryFinal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book_series")
public class BookSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "bookSeries")
    Set<Book> books;
    private String name;
    private String description;

    public BookSeries() {
    }

    public BookSeries(String name, Long id, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public BookSeries(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
