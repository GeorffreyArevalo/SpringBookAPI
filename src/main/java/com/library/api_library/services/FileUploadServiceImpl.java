package com.library.api_library.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.library.api_library.entities.BookEntity;
import com.library.api_library.exceptions.BodyNotValidException;
import com.library.api_library.exceptions.InternalServerErrorException;
import com.library.api_library.services.interfaces.BookService;
import com.library.api_library.services.interfaces.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BookService bookService;

    @SuppressWarnings("unchecked")
    @Override
    public BookEntity upload(Long id, MultipartFile file) {
        
        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "webp", "avif");

        BookEntity book = bookService.findById(id);

        String extensions = null;

        if( file.getOriginalFilename() != null ) {
            String[] splitName = file.getOriginalFilename().split("\\.");
            extensions = splitName[splitName.length - 1];
        }

        if( !allowedExtensions.contains(extensions) ) throw new BodyNotValidException(
            String.format("Extension %s not allowed.", extensions)
        );

        try {
            
            Map<String, Object> resultUpload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "library"));

            String imageUrl = resultUpload.get("secure_url").toString();

            book.setImage(imageUrl);

            bookService.update(id, book);

            return book;
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }



    }
    
}
