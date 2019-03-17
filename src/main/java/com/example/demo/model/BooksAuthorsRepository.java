package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface BooksAuthorsRepository extends CrudRepository<BooksAuthors, Long> {
    Iterable<BooksAuthors> findAllByBook_Id(Long book_id);
    Iterable<BooksAuthors> findAllByAuthor_Id(Long author_id);
}
