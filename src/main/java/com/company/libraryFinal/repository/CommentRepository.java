package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBookId(Long id);
}
