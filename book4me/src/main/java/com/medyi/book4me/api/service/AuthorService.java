package com.medyi.book4me.api.service;

import com.medyi.book4me.api.model.Author;
import com.medyi.book4me.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public List<Author> selectAllAuthor() {
        return authorRepository.findAll();

    }

    public Author selectAuthorById(long id) {
        return authorRepository.findById(id).get();
    }

    public void deleteAuthorById(long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthorById(long id, Author author) {
        Author authorNew = authorRepository.findById(id).get();

        authorNew.setFirstName(author.getFirstName());
        authorNew.setLastName(author.getLastName());
        authorNew.setBookList(author.getBookList());

        Author updatedAuthor = authorRepository.save(authorNew);
        return updatedAuthor;

    }

}
