package com.day11session2.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.day11session2.flightbooking.exception.InvalidBookingException;
import com.day11session2.flightbooking.exception.NoFlightsFoundException;
import com.day11session2.flightbooking.model.Flight;
import com.day11session2.flightbooking.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity) throws NoFlightsFoundException {
        List<Flight> flights = flightService.searchFlights(departureCity, arrivalCity);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @PostMapping("/book/{flightNumber}")
    public ResponseEntity<String> bookFlight(
            @PathVariable String flightNumber,
            @RequestBody String username) throws InvalidBookingException {
        String bookingId = flightService.bookFlight(flightNumber, username);
        return new ResponseEntity<>("Booking successful. Booking ID: " + bookingId, HttpStatus.CREATED);
    }

    @ExceptionHandler(NoFlightsFoundException.class)
    public ResponseEntity<String> handleNoFlightsFoundException(NoFlightsFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<String> handleInvalidBookingException(InvalidBookingException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}