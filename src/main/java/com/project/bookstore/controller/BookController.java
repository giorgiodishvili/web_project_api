package com.project.bookstore.controller;

import com.project.bookstore.entity.Book;
import com.project.bookstore.service.BookService;
import com.project.bookstore.utils.ListAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@RestController
@RequestMapping("/api/book")
@Validated
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<Book> getAllBooks(Pageable pageable) {
        return ListAdapter.createPageFromList(bookService.getAllBooks(), pageable);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") @Min(1) Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable("bookId") @Min(1) Long bookId, @RequestBody @Valid Book book) {
        return bookService.updateBook(Math.toIntExact(bookId),book);
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable("bookId") @Min(1) Long bookId) {
        return bookService.deleteBookById(bookId);
    }
}
