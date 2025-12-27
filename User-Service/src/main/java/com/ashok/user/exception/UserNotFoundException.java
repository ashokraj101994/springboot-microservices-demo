package com.ashok.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
    	super(msg);
    }
}
