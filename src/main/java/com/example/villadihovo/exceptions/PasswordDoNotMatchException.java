package com.example.villadihovo.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{

    public PasswordDoNotMatchException(){
        super("Password Do Not Match");
    }
}
