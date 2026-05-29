package com.gregorio.poker.exception;

public class HandLimitExceededException extends Exception {
    public HandLimitExceededException(String message) {
        super(message);
    }
}
