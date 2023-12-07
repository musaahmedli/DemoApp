package com.example.demo.Core.CustomExceptions;

public class UserNotAuthorizedException extends Exception{
    public UserNotAuthorizedException(String message) {
        super(message);
    }
}
