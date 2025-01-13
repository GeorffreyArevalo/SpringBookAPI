package com.library.api_library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.api_library.entities.CategoryEntity;
import com.library.api_library.services.interfaces.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        return ResponseEntity.ok( categoryService.findAll() );
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> save( @RequestBody CategoryEntity category ) {
        return ResponseEntity.ok( categoryService.save(category) );
    }

}
