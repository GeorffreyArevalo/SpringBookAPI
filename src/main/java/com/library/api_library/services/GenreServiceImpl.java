package com.library.api_library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.api_library.entities.GenreEntity;
import com.library.api_library.exceptions.DataNotFoundException;
import com.library.api_library.repositories.GenreRepository;
import com.library.api_library.services.interfaces.GenreService;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreEntity> findAll() {
        return (List<GenreEntity>) genreRepository.findAll();
    }

    @Override
    public GenreEntity findById(Long id) {
        return genreRepository.findById(id).orElseThrow(
            () -> new DataNotFoundException(String.format("Genre with id %s not exists.", id))
        );
    }

    @Override
    public GenreEntity save(GenreEntity genre) {
        return genreRepository.save(genre);
    }
    
}
