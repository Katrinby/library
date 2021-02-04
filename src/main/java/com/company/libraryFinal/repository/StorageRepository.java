package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    List<Storage> findAll();
    Storage findStorageById(Long id);
}