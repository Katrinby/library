package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByBookId(Long id);
}
