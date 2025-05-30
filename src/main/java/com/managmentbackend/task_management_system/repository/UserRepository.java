package com.managmentbackend.task_management_system.repository;

import com.managmentbackend.task_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
