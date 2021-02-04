package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByLname(String lname);

    List<Author> findAllByLname(String lname);

    Author findAuthorById(Long Id);

    boolean existsAuthorByLname(String lname);
}
