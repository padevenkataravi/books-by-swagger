package com.ravi.booksbyswagger.service;

import com.ravi.booksbyswagger.entity.Book;

import java.util.List;

public interface BooksService {
    String upsertBook(Book book);

    List<Book> getAllBooks();

    String deleteBook(Integer id);
}
