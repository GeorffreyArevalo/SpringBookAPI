package com.library.api_library.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.library.api_library.entities.BookEntity;

public interface FileUploadService {
    
    BookEntity upload( Long id, MultipartFile file );

}
