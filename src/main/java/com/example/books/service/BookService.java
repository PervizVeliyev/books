package com.example.books.service;

import com.example.books.entity.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book updateBook(Book book){
        Book oldBook = bookRepository.findById(book.getId()).orElse(null);
        if(oldBook == null) return new Book();
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPublishYear(book.getPublishYear());
        bookRepository.save(oldBook);
        return oldBook;
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
