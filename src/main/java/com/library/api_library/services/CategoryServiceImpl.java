package com.library.api_library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.api_library.entities.CategoryEntity;
import com.library.api_library.exceptions.DataNotFoundException;
import com.library.api_library.repositories.CategoryRepository;
import com.library.api_library.services.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
            () -> new DataNotFoundException(
                String.format("Category with id %s does not exists.", id)
            )
        );
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {

        if( category.getBooks() != null && !category.getBooks().isEmpty() ) {
            category.getBooks().forEach(category::addBook);
        }

        return categoryRepository.save(category);
    }

    

}
