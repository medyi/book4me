package com.medyi.book4me.api.service;

import com.medyi.book4me.api.model.Book;
import com.medyi.book4me.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


        public Book addBook(Book book) {
            bookRepository.save(book);
            return book;
        }

        public List<Book> selectAllBook() {
            return bookRepository.findAll();

        }

        public Book selectBookById(long id) {
            return bookRepository.findById(id).get();
        }

        public void deleteBookById(long id) {
            bookRepository.deleteById(id);
        }

        public Book updateBookById(long id, Book book) {

            Book bookNew = bookRepository.findById(id).get();

            bookNew.setAuthor(book.getAuthor());
            bookNew.setCategory(book.getCategory());
            bookNew.setISBN(book.getISBN());
            bookNew.setTitle(book.getTitle());

            Book updatedBook = bookRepository.save(bookNew);
            return updatedBook;


    }


}
