package com.example.villadihovo.service.impl.usersImpl;

import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.repository.users.UserRepository;
import com.example.villadihovo.service.users.UserService;
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
