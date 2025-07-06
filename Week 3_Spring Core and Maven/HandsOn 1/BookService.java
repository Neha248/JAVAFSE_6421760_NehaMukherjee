package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookRepository;

    // Manual object creation
    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public void enterBook(String title) {
        System.out.println("Entering book: " + title);
        bookRepository.addBook(title);
    }
}
