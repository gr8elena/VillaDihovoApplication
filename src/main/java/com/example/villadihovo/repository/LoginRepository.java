package com.example.villadihovo.repository;

import com.example.villadihovo.model.attempts.LogIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LogIn, Integer> {
}
