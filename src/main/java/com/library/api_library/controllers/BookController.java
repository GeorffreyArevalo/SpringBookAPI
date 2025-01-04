package com.library.api_library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.api_library.entities.BookEntity;
import com.library.api_library.exceptions.BodyNotValidException;
import com.library.api_library.services.interfaces.BookService;

import jakarta.validation.Valid;

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
    public ResponseEntity<?> createBook(@Valid @RequestBody BookEntity book, BindingResult result) {

        if( result.hasFieldErrors() ) {

            FieldError error = result.getFieldErrors().get(0);
            throw new BodyNotValidException(
                String.format("The %s field %s", error.getField(), error.getDefaultMessage())
            );

        }

        return ResponseEntity.ok( bookService.save(book) );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,@Valid @RequestBody BookEntity book, BindingResult result) {
        if( result.hasFieldErrors() ) {
            result.getFieldErrors().forEach( error -> {
                if( !error.getCode().equals("NotEmpty") ){
                    throw new BodyNotValidException(
                        String.format("The %s field %s", error.getField(), error.getDefaultMessage())
                    );
                }
            });
        }
        return ResponseEntity.ok( bookService.update(id, book) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id));
    }


}
