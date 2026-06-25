package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load Spring context from XML config
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n=== Spring Context Loaded Successfully ===\n");

        // Get BookService bean from context
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n=== Testing BookService Operations ===\n");

        // Test add book
        bookService.addBook("Spring in Action");
        System.out.println();

        // Test get book
        String book = bookService.getBook(1);
        System.out.println("Retrieved: " + book);
        System.out.println();

        // Test remove book
        bookService.removeBook(1);

        System.out.println("\n=== Application Completed Successfully ===");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}