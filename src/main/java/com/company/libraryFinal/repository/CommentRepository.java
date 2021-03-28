package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByBookId(Long id, Pageable pageable);
}
