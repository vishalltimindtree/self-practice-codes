package com.passport.passportproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passport.passportproject.model.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, String> {

}
