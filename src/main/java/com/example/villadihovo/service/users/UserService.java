package com.example.villadihovo.service.users;

import com.example.villadihovo.model.users.UserTable;

import java.util.Optional;

public interface UserService {
    Optional<UserTable> findByUsernameAndPassword(String username, String password);
}
