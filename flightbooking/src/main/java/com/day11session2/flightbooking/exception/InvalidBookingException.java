package com.day11session2.flightbooking.exception;

public class InvalidBookingException  extends Exception {
    public InvalidBookingException (String message) {
        super(message);
    }
}