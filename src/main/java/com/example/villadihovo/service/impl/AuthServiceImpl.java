package com.example.villadihovo.service.impl;

import com.example.villadihovo.exceptions.InvalidArgumentException;
import com.example.villadihovo.exceptions.InvalidUserCredentialsException;
import com.example.villadihovo.exceptions.PasswordDoNotMatchException;
import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.repository.UserRepository;
import com.example.villadihovo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private  UserRepository userTableRepository;

    @Override
    public UserTable login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }
        return userTableRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }


    @Override
    public UserTable register(String embg, String address, String email, String username, String password, String repeatPassword, String full_name, String phone_number) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            throw new InvalidArgumentException();
        }
        if(!password.equals(repeatPassword))
        {
            throw new PasswordDoNotMatchException();
        }
        UserTable userTable = new UserTable(embg, address, email, password, username, full_name, phone_number);
        return userTableRepository.save(userTable);
    }
}
