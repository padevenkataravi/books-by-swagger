package com.ravi.booksbyswagger.service;

import com.ravi.booksbyswagger.entity.Book;
import com.ravi.booksbyswagger.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private BooksRepository repository;

    @Autowired
    public BooksServiceImpl(BooksRepository repository) {
        this.repository = repository;
    }

    @Override
    public String upsertBook(Book book) {
        Integer bookId = book.getId();
        Book saved = repository.save(book);
       return "Book saved successfully " ;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public String deleteBook(Integer id) {
        repository.deleteById(id);
        return "delete successfully ::::: " + id;
    }
}
