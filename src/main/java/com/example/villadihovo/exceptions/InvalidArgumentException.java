package com.example.villadihovo.exceptions;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(){
        super("Login failed! Enter username and password.");
    }
}
