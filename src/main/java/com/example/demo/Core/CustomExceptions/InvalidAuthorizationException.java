package com.example.demo.Core.CustomExceptions;

public class InvalidAuthorizationException extends Exception{
    public InvalidAuthorizationException(String message) {
        super(message);
    }
}
