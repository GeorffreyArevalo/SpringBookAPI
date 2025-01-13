package com.library.api_library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.api_library.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    
}
