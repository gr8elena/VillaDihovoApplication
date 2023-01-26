package com.example.villadihovo.service;

import com.example.villadihovo.model.users.UserTable;

public interface AuthService {

    UserTable login(String username, String password);
    UserTable register(String embg, String address, String email, String username, String password, String repeatPassword, String full_name, String phone_number);
}
