package com.mikemunhall.jara.service;

public class InvalidUserException extends Exception {

    public InvalidUserException() { }

    public InvalidUserException(String message) {
        super(message);
    }

}
