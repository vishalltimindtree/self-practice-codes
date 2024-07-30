package com.passport.passportproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.passport.passportproject.model.Person;
import com.passport.passportproject.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public void createPersons() {
        // Create persons
        personService.createPersons();
    }

    @GetMapping("/passport/{passportId}")
    public ResponseEntity<Person> getPersonByPassportId(@PathVariable String passportId) {
        // Get person by passportId
        // Return 200 OK if found, 404 Not Found if not found
        Person person = personService.getPersonByPassportId(passportId);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        // Get person by passportId
        // Return 200 OK if found, 404 Not Found if not found
        Person person = personService.getPersonById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Person> getAllPersons() {
        // Get all persons
        return personService.getAllPersons();
    }

}
