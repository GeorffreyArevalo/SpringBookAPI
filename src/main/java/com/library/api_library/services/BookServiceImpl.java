package com.library.api_library.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.api_library.entities.BookEntity;
import com.library.api_library.entities.CategoryEntity;
import com.library.api_library.entities.GenreEntity;
import com.library.api_library.exceptions.BodyNotValidException;
import com.library.api_library.exceptions.DataNotFoundException;
import com.library.api_library.exceptions.InternalServerErrorException;
import com.library.api_library.repositories.BookRepository;
import com.library.api_library.services.interfaces.BookService;
import com.library.api_library.services.interfaces.CategoryService;
import com.library.api_library.services.interfaces.GenreService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GenreService genreService;

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

            if( book.getCategory() != null ) book.setCategory(getCategory(book));


            if( book.getGenres() != null && !book.getGenres().isEmpty() ) {

                Set<GenreEntity> genresFound = new HashSet<>();

                for (GenreEntity genre: book.getGenres()) {
                    
                    if( genre.getId() != null ) {
                        GenreEntity genreFound = genreService.findById(genre.getId());
                        genresFound.add(genreFound);
                    } else {
                        genresFound.add(genre);
                    }

                }

                book.setGenres(genresFound);

            }

        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

    }

    @Override
    public BookEntity update(Long id, BookEntity book) {
        BookEntity bookFound = findById(id);

        if( book.getTitle() != null ) bookFound.setTitle(book.getTitle());
        if( book.getAuthor() != null ) bookFound.setAuthor(book.getAuthor());
        if( book.getImage() != null ) bookFound.setImage(book.getImage());
        if( book.getState() != null ) bookFound.setState(book.getState());
        if( book.getInStock() != null ) bookFound.setInStock(book.getInStock());

        if( book.getCategory() != null ) bookFound.setCategory( getCategory(book) );

        if( book.getGenres() != null && !book.getGenres().isEmpty() ) bookFound.setGenres(book.getGenres());
        

        try {
            return bookRepository.save(bookFound);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }


    }

    @Override
    public BookEntity delete(Long id) {
        BookEntity bookFound = findById(id);
        bookRepository.deleteById(id);
        return bookFound;
    }
    

    private CategoryEntity getCategory( BookEntity book ) {
        CategoryEntity category;
        if( book.getCategory().getId() == null ) {
            category = categoryService.save(book.getCategory());
        }else {
            category = categoryService.findById( book.getCategory().getId() );
        }
        return category;
    }


}
