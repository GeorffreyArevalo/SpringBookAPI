package com.library.api_library.services.interfaces;

import java.util.List;

import com.library.api_library.entities.GenreEntity;

public interface GenreService {
    
    List<GenreEntity> findAll();

    GenreEntity findById( Long id );

    GenreEntity save(GenreEntity genre);

}
