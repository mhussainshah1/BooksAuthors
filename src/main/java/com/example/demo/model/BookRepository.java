package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAllByAuthors_Id(long author_id);
}
