package com.example.demo;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String SKU;

    @NonNull
    @Size(min = 4)
    private String title;

    @NonNull
    @Size(min = 10)
    private String description;

    @NonNull
    @Min(0)
    private double price;

    @NonNull
    private boolean isInStock;

    @ManyToMany
    private Set<Author> authors;

    public Book() {
        authors = new HashSet<>();
    }

    public Book(String SKU, @Size(min = 4) String title, @Size(min = 10) String description, @Min(0) double price, boolean isInStock) {
        this.SKU = SKU;
        this.title = title;
        this.description = description;
        this.price = price;
        this.isInStock = isInStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", SKU='" + SKU + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isInStock=" + isInStock +
                ", authors=" + authors +
                '}';
    }
}

