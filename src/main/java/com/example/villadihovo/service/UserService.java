package com.example.villadihovo.service;

import com.example.villadihovo.model.user_table;

import java.util.Optional;

public interface UserService {
    Optional<user_table> findByUsernameAndPassword(String username, String password);
}
