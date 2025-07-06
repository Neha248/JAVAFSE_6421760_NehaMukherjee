package com.project.Library_Management;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the bookService bean
        BookService bookService = new BookService();

        // Use the service
        bookService.enterBook("The Great Gatsby");
    }
}
