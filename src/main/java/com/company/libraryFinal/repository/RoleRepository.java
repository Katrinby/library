package com.company.libraryFinal.repository;
import com.company.libraryFinal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByRole(String role);
    Role findRoleByRole(String role);
}
