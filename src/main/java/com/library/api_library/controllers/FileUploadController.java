package com.library.api_library.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    
    @PatchMapping("/books/{id}")
    public ResponseEntity<?> upload() {
        return ResponseEntity.ok("upload");
    }

}
