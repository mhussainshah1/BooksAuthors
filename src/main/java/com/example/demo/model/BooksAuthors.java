package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BooksAuthors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

    public BooksAuthors() {
        book = new Book();
        author = new Author();
    }

    public BooksAuthors(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BooksAuthors{" +
                "id=" + id +
                ", book=" + book.getTitle() +
                ", author=" + author.getName() +
                '}';
    }
}
