package com.example.demo.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Size(min = 3)
    private String name;

    @OneToMany(mappedBy = "book")
    private Set<BooksAuthors> booksAuthors;

    public Author() {
        booksAuthors = new HashSet<>();

    }

    public Author(@Size(min = 3) String name) {
        this();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BooksAuthors> getBooksAuthors() {
        return booksAuthors;
    }

    public void setBooksAuthors(Set<BooksAuthors> booksAuthors) {
        this.booksAuthors = booksAuthors;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", booksAuthors=" + booksAuthors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Author author = (Author) o;
        return id == author.id &&
                name.equals(author.name);
    }
}
