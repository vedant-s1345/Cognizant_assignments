package com.library.repository;

public class BookRepository {

    public void save(String book) {
        System.out.println("BookRepository: Saving book — " + book);
    }

    public String findById(int id) {
        System.out.println("BookRepository: Finding book with ID — " + id);
        return "Book_" + id;
    }

    public void delete(int id) {
        System.out.println("BookRepository: Deleting book with ID — " + id);
    }
}