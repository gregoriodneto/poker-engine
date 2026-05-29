package com.gregorio.poker.exception;

public class QuantityPlayersExceededTableException extends Exception {
    public QuantityPlayersExceededTableException(String message) {
        super(message);
    }
}
