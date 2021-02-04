package com.company.libraryFinal.repository;


import com.company.libraryFinal.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findGenreById(Long id);
    List<Genre> findAll();

}
