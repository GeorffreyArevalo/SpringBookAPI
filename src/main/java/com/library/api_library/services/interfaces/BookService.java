package com.library.api_library.services.interfaces;
import java.util.List;
import java.util.Map;

import com.library.api_library.entities.BookEntity;

public interface BookService {
    
    List<BookEntity> findAll();
    BookEntity findById(Long id);
    BookEntity save(BookEntity book);
    
    BookEntity update(Long id, BookEntity book);
    
    Map<String, Object> delete(Long id);

}
