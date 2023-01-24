package com.example.villadihovo.service.impl;

import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.repository.UserRepository;
import com.example.villadihovo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public Optional<UserTable> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
