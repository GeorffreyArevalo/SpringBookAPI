package com.library.api_library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.api_library.entities.GenreEntity;
import com.library.api_library.services.interfaces.GenreService;


@RestController
@RequestMapping("/genres")
public class GenreController {
    
    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity< List<GenreEntity>> findAll() {
        return ResponseEntity.ok( genreService.findAll() );
    }

    @PostMapping
    public ResponseEntity<GenreEntity> save( @RequestBody GenreEntity genre ) {
        return ResponseEntity.ok( genreService.save(genre) );
    }
    

}
