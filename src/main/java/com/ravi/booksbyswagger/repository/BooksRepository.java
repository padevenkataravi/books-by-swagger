package com.ravi.booksbyswagger.repository;

import com.ravi.booksbyswagger.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
