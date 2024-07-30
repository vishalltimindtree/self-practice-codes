package com.day11session2.flightbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.day11session2.flightbooking.exception.InvalidBookingException;
import com.day11session2.flightbooking.exception.NoFlightsFoundException;
import com.day11session2.flightbooking.model.Booking;
import com.day11session2.flightbooking.model.Flight;

import jakarta.annotation.PostConstruct;

@Service
public class FlightService {
    private List<Flight> flights = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public List<Flight> searchFlights(String departureCity, String arrivalCity) throws NoFlightsFoundException {
        List<Flight> matchingFlights = flights.stream()
                .filter(f -> f.getDepartureCity().equals(departureCity) &&
                             f.getArrivalCity().equals(arrivalCity) &&
                             f.getAvailableSeats() > 0)
                .collect(Collectors.toList());

        if (matchingFlights.isEmpty()) {
            throw new NoFlightsFoundException("No flights found for the given criteria");
        }

        return matchingFlights;
    }

    public String bookFlight(String flightNumber, String username) throws InvalidBookingException {
        Flight flight = flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElseThrow(() -> new InvalidBookingException("Invalid flight number"));

        if (flight.getAvailableSeats() <= 0) {
            throw new InvalidBookingException("Flight is fully booked");
        }

        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, flightNumber, username);
        bookings.add(booking);

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);

        return bookingId;
    }

    @PostConstruct
    public void initFlights() {
        flights.add(new Flight("FL001", "New York", "London", "2024-07-15 10:00", 100));
        flights.add(new Flight("FL002", "London", "Paris", "2024-07-16 14:00", 80));
        flights.add(new Flight("FL003", "Paris", "Tokyo", "2024-07-17 09:00", 150));
    }
}