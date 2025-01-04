package com.library.api_library.entities;

import com.library.api_library.enums.StateBook;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "books" )
public class BookEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty( message = "can't be empty." )
    @Size( min = 3, message = "must be least 3 characters." )
    private String title;

    @NotEmpty( message = "can't be empty." )
    @Size( min = 3, message = "must be least 3 characters." )
    private String author;

    private String image;

    @Enumerated( EnumType.STRING )
    private StateBook state; // 'AVAILABLE - OUT_OF_STOCK - SOON'

    @Min( value = 0 )
    @Column( nullable = false, columnDefinition = "integer default 0" )
    private Integer inStock;

    public BookEntity() {
    }

    public BookEntity(Long id, @NotEmpty @Size(min = 3) String title, @NotEmpty @Size(min = 3) String author,
            String image, StateBook state, @Min(0) Integer inStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.state = state;
        this.inStock = inStock;
    }

    @PrePersist
    public void prePersist() {
        if( inStock == null ) inStock = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StateBook getState() {
        return state;
    }

    public void setState(StateBook state) {
        this.state = state;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    


}
