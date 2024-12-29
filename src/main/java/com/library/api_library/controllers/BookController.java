package com.library.api_library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.api_library.entities.BookEntity;
import com.library.api_library.services.interfaces.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<?> getBook(@PathVariable( name = "idBook" ) Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok( bookService.save(book) );
    }

    @PatchMapping("/id")
    public ResponseEntity<?> updateBook() {
        return ResponseEntity.ok("Update Book");
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deleteBook() {
        return ResponseEntity.ok("Delete Book");
    }


}
