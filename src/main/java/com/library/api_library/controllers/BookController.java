package com.library.api_library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @GetMapping
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok("Get Books");
    }

    @GetMapping("/id")
    public ResponseEntity<?> getBook() {
        return ResponseEntity.ok("Get a Book");
    }

    @PostMapping
    public ResponseEntity<?> createBook() {
        return ResponseEntity.ok("Crate Book");
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
