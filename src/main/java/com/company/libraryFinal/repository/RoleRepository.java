package com.company.libraryFinal.repository;
import com.company.libraryFinal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
