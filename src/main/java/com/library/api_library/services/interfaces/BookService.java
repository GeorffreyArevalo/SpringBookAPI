package com.library.api_library.services.interfaces;
import java.util.List;

import com.library.api_library.entities.BookEntity;

public interface BookService {
    
    List<BookEntity> findAll();
    BookEntity findById(Long id);
    BookEntity save(BookEntity book);
    BookEntity update(Long id, BookEntity book);
    BookEntity delete(Long id);

}
