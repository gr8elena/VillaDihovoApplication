package com.example.villadihovo.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException(){
        super("Login failed! Incorrect username or password.");
    }
}
