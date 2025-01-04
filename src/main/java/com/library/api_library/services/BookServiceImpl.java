package com.library.api_library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.api_library.entities.BookEntity;
import com.library.api_library.exceptions.BodyNotValidException;
import com.library.api_library.exceptions.DataNotFoundException;
import com.library.api_library.exceptions.InternalServerErrorException;
import com.library.api_library.repositories.BookRepository;
import com.library.api_library.services.interfaces.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> findAll() {
        try {

            //* Force an exception */
            // String title = null;
            // int size = title.length();
            return (List<BookEntity>) bookRepository.findAll();
        } catch (Exception err) {
          throw new InternalServerErrorException(err.getMessage());
        }

    }

    @Override
    public BookEntity findById(Long id) {
        return bookRepository.findById(id).orElseThrow( () -> new DataNotFoundException(String.format("The book with id %s not found.", id)) );
    }

    @Override
    public BookEntity save(BookEntity book) {

        bookRepository.findByTitle(book.getTitle())
            .ifPresent( bookDB -> {
                throw new BodyNotValidException(String.format("Book with title %s already exists", bookDB.getTitle()));
            });

        return bookRepository.save(book);
    }

    @Override
    public BookEntity update(Long id, BookEntity book) {
        BookEntity bookFound = findById(id);

        if( book.getTitle() != null ) bookFound.setTitle(book.getTitle());
        if( book.getAuthor() != null ) bookFound.setAuthor(book.getAuthor());
        if( book.getImage() != null ) bookFound.setImage(book.getImage());
        if( book.getState() != null ) bookFound.setState(book.getState());
        if( book.getInStock() != null ) bookFound.setInStock(book.getInStock());


        return bookRepository.save(bookFound);

    }

    @Override
    public BookEntity delete(Long id) {
        BookEntity bookFound = findById(id);
        bookRepository.deleteById(id);
        return bookFound;
    }
    


}
