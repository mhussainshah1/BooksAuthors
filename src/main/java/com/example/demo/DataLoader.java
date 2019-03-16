package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorRepository;
import com.example.demo.model.Book;
import com.example.demo.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Set<Author> authors = new HashSet<>();
        Author author = new Author("Kathy Sierra");
        authors.add(author);
//        author = new Author("Bert Bates");
//        authors.add(author);
        Book book = new Book("Java1001", "Head First Java","Easy to read Java workbook", 47.50, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);

        authors = new HashSet<>();
        author = new Author("Bruce Eckel");
        authors.add(author);
        book = new Book("Java1002", "Thinking in Java", "Details about Java under the hood", 20.00, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);

        authors = new HashSet<>();
        author = new Author("Jeanne Boyarsky");
        authors.add(author);
        book = new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Everything you need to know in one place", 45.00, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);

        authors = new HashSet<>();
        author = new Author("Al Sweigart");
        authors.add(author);
        book = new Book("Python1004", "Automate the Boring Stuff with Python",  "Fun with Python", 10.50, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);

        authors = new HashSet<>();
        author = new Author("Simon Monk");
        authors.add(author);
        book = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse",  "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, false);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);

        authors = new HashSet<>();
        author = new Author("Donald Norris");
        authors.add(author);
        book = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        repository.save(book);
    }
}
