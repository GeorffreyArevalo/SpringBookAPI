package com.library.api_library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.api_library.entities.BookEntity;
import com.library.api_library.repositories.BookRepository;
import com.library.api_library.services.interfaces.BookService;

import jakarta.validation.ValidationException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> findAll() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public BookEntity findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public BookEntity save(BookEntity book) {

        bookRepository.findByTitle(book.getTitle())
            .ifPresent( bookDB -> {
                throw new ValidationException(String.format("Book with title %s already exists", bookDB.getTitle()));
            });

        return bookRepository.save(book);
    }

    @Override
    public BookEntity update(Long id, BookEntity book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public BookEntity delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    


}
