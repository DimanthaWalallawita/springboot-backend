package com.managmentbackend.task_management_system.repository;

import com.managmentbackend.task_management_system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByEmail(String email);
}
