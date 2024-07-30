package com.day16session2.socialnetworking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day16session2.socialnetworking.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
