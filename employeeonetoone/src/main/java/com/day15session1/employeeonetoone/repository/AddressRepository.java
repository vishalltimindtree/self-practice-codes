package com.day15session1.employeeonetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day15session1.employeeonetoone.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
