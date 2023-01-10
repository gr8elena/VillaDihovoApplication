package com.example.villadihovo.repository;

import com.example.villadihovo.model.user_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user_table, Long> {
    Optional<user_table> findByUsernameAndPassword(String username, String password);
}
