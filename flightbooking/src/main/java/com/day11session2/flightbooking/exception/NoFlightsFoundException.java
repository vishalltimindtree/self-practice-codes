package com.day11session2.flightbooking.exception;

public class NoFlightsFoundException extends Exception {
    public NoFlightsFoundException(String message) {
        super(message);
    }
}
