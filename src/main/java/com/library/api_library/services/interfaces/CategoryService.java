package com.library.api_library.services.interfaces;

import java.util.List;

import com.library.api_library.entities.CategoryEntity;

public interface CategoryService {
    
    List<CategoryEntity> findAll();

    CategoryEntity findById(Long id);

    CategoryEntity save(CategoryEntity category);

}
