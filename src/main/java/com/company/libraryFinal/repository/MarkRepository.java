package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Book;
import com.company.libraryFinal.entity.Mark;
import com.company.libraryFinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByBookId(Long id);
    Boolean existsMarkByUser(User user);
    Mark findMarkByUserAndBook(User user, Book book);
    List<Mark> findMarksByBookId(Long id);
}
