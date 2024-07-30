package com.day12session2.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day12session2.librarymanagement.exception.NoSuchBookException;
import com.day12session2.librarymanagement.model.Book;
import com.day12session2.librarymanagement.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) throws NoSuchBookException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchBookException("No book found with id: " + id));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookById(Long id, Book bookDetails) throws NoSuchBookException {
        Book existingBook = getBookById(id);
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setIsbn(bookDetails.getIsbn());
        existingBook.setQuantity(bookDetails.getQuantity());

        return bookRepository.save(existingBook);
    }

    public void deleteBookById(Long id) throws NoSuchBookException {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}