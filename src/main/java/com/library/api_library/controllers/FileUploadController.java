package com.library.api_library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.library.api_library.services.interfaces.FileUploadService;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;
    
    @PatchMapping("/books/{id}")
    public ResponseEntity<?> upload(
        @PathVariable Long id,
        @RequestParam("image") MultipartFile file
    ) {
        return ResponseEntity.ok( fileUploadService.upload(id, file) );
    }

}
