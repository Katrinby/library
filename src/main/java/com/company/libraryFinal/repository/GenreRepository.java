package com.company.libraryFinal.repository;


import com.company.libraryFinal.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findGenreById(Long id);
    Page<Genre> findAll(Pageable pageable);
    List<Genre> findAll();
    Boolean existsGenreByName(String name);
    Genre findGenreByName(String name);

}
