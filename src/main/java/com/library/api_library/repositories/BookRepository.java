package com.library.api_library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.api_library.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    
}
