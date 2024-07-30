package com.passport.passportproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passport.passportproject.model.Passport;
import com.passport.passportproject.model.Person;
import com.passport.passportproject.repository.PersonRepository;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPersons() {
        // create 5 persons with associated passports
        Person person1 = new Person("John Doe", new Date(90, 4, 15), "New York");
        Passport passport1 = new Passport("1", "New York", new Date(120, 0, 1));
        person1.setPassport(passport1);

        Person person2 = new Person("Jane Smith", new Date(85, 7, 22), "Los Angeles");
        Passport passport2 = new Passport("2", "Los Angeles", new Date(119, 5, 15));
        person2.setPassport(passport2);

        Person person3 = new Person("Mike Johnson", new Date(92, 2, 10), "Chicago");
        Passport passport3 = new Passport("3", "Chicago", new Date(121, 3, 30));
        person3.setPassport(passport3);

        Person person4 = new Person("Emily Brown", new Date(88, 10, 5), "Houston");
        Passport passport4 = new Passport("4", "Houston", new Date(118, 8, 20));
        person4.setPassport(passport4);

        Person person5 = new Person("David Wilson", new Date(95, 6, 18), "Miami");
        Passport passport5 = new Passport("5", "Miami", new Date(122, 1, 28));
        person5.setPassport(passport5);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);
    }

    public Person getPersonByPassportId(String passportId) {
        // return the person with the given passportId
        Person p = personRepository.findByPassportId(passportId);
        if (p != null) {
            return p;
        }
        return null;
    }

    public List<Person> getAllPersons() {
        // return all persons
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        Person p = personRepository.findById(id).orElse(null);

        if (p != null) {
            return p;
        }
        return null;
    }

}
