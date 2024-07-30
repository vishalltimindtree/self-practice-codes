package com.day12session2.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day12session2.librarymanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}