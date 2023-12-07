package com.example.demo.Core.CustomExceptions;

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
