package com.medyi.book4me.api.controller;

import com.medyi.book4me.api.model.Book;
import com.medyi.book4me.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/api/v1/book")
@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@Valid @NonNull @RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.selectAllBook();
    }

    @GetMapping(path="/{id}")
    public Book getBookById(@PathVariable("id") long id) {
        return bookService.selectBookById(id);
    }

    @DeleteMapping(path="/{id}")
    public void deleteBookById(@PathVariable("id") long id){
        bookService.deleteBookById(id);
    }

    @PutMapping(path = "/{id}")
    public Book updateBookById(@PathVariable("id") long id, @Valid @NonNull @RequestBody Book book){
        return bookService.updateBookById(id, book);
    }

}
