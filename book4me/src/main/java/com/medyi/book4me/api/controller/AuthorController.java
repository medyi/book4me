package com.medyi.book4me.api.controller;

import com.medyi.book4me.api.model.Author;
import com.medyi.book4me.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/author")
@RestController
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public void addAuthor(@Valid @NonNull @RequestBody Author author){
        authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.selectAllAuthor();
    }

    @GetMapping(path="/{id}")
    public Author getAuthorById(@PathVariable("id") long id) {
        return authorService.selectAuthorById(id);
    }

    @DeleteMapping(path="/{id}")
    public void deleteAuthorById(@PathVariable("id") long id){
        authorService.deleteAuthorById(id);
    }

    @PutMapping(path = "/{id}")
    public Author updateAuthorById(@PathVariable("id") long id, @Valid @NonNull @RequestBody Author author){
        return authorService.updateAuthorById(id, author);
    }

}
