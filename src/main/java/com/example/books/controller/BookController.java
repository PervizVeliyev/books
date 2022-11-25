package com.example.books.controller;

import com.example.books.entity.Book;
import com.example.books.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
