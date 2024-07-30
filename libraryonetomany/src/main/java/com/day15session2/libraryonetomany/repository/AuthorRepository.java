package com.day15session2.libraryonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day15session2.libraryonetomany.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
