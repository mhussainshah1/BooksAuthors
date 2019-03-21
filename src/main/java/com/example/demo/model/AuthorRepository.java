package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String author_name);
    Iterable<Author> findAllByNameContainingIgnoreCase(String author_name);
}
