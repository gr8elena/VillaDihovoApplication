package com.example.villadihovo.repository.users;

import com.example.villadihovo.model.users.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    Optional<UserTable> findByUsernameAndPassword(String username, String password);
    Optional<UserTable> findByUsername(String username);
}
