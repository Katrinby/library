package com.company.libraryFinal.repository;

import com.company.libraryFinal.entity.Storage;
import com.company.libraryFinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    List<Storage> findAll();
    List<Storage> findStoragesByUser(User user);
    Storage findStorageById(Long id);
    Boolean existsStorageByName(String name);
}