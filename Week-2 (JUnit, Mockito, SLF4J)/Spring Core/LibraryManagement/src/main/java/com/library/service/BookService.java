package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected successfully");
    }

    public void addBook(String book) {
        System.out.println("BookService: Adding book — " + book);
        bookRepository.save(book);
    }

    public String getBook(int id) {
        System.out.println("BookService: Getting book with ID — " + id);
        return bookRepository.findById(id);
    }

    public void removeBook(int id) {
        System.out.println("BookService: Removing book with ID — " + id);
        bookRepository.delete(id);
    }
}