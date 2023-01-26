package com.example.villadihovo.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException(){
        super("Invalid User Credentials");
    }
}
