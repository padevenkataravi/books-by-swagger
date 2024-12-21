package com.ravi.booksbyswagger.controller;

import com.ravi.booksbyswagger.entity.Book;
import com.ravi.booksbyswagger.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping(consumes = ("application/json"))
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        String book1 = booksService.upsertBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = booksService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Operation(summary = "delete by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> getBookById(@PathVariable("id") int id) {
        String book2 = booksService.deleteBook(id);
        return new ResponseEntity<>(book2, HttpStatus.OK);
    }
}
