package com.library.api_library.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table( name = "categories" )
public class CategoryEntity {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty( message = "doesn't be empty." )
    private String name;

    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "category", fetch = FetchType.LAZY )
    @JsonIgnoreProperties( value = {"category"} )
    private Set<BookEntity> books;


    public CategoryEntity() {

        books = new HashSet<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    public void addBook( BookEntity book ) {
        books.add(book);
        book.setCategory(this);
    }

}
