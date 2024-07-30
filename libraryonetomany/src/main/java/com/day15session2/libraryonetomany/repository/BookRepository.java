package com.day15session2.libraryonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day15session2.libraryonetomany.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}