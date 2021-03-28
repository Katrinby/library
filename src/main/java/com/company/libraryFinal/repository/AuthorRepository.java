package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByLname(String lname);

    List<Author> findAllByLnameContains(String lname);
    Page<Author> findAllByLnameContains(String lname, Pageable pageable);

    List<Author> findAll();
    Page<Author> findAll(Pageable pageable);

    Author findAuthorById(Long Id);

    boolean existsAuthorByLname(String lname);
    boolean existsAuthorByLnameAndFname(String lname, String fname);
}
