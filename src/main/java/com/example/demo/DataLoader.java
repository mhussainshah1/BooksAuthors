package com.example.demo;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        //one book one author
        Author author = new Author("Bruce Eckel");
        Book book = new Book("Java1002", "Thinking in Java", "One Author one Book : - Details about Java under the hood", 20.00, true);
        BooksAuthors booksAuthors = new BooksAuthors(book, author);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author);
        bookRepository.save(book);

        //Two authors one book
/*        book = new Book("Java1001", "Head First Java","Two authors one book: - Easy to read Java workbook", 47.50, true);
        Author author1 = new Author("Kathy Sierra");
        booksAuthors = new BooksAuthors(book, author1);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author1);
        bookRepository.save(book);

        Author author2 = new Author("Bert Bates");
        booksAuthors = new BooksAuthors(book, author2);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author2);
        bookRepository.save(book);*/

        //Two authors one book
        book = new Book("Java1001", "Head First Java","Two authors one book: - Easy to read Java workbook", 47.50, true);
        Set<BooksAuthors> booksAuthorsSet = new HashSet<>();
        Author author1 = new Author("Kathy Sierra");
        booksAuthors = new BooksAuthors(book, author1);
        booksAuthorsSet.add(booksAuthors);

        Author author2 = new Author("Bert Bates");
        booksAuthors = new BooksAuthors(book, author2);
        booksAuthorsSet.add(booksAuthors);

        book.setBooksAuthors(booksAuthorsSet);
        authorRepository.save(author1);
        authorRepository.save(author2);
        bookRepository.save(book);

        //one author two books
        author = new Author("Jeanne Boyarsky");
        Book book1 = new Book("Orcl1003",
                "OCA 8: Oracle Certified Associate Java Programmer",
                "One author two books : - Everything you need to know in OCA exam",
                45.00,
                true);
        booksAuthors = new BooksAuthors(book1, author);
        book1.getBooksAuthors().add(booksAuthors);
        Book book2 = new Book("Orcl1004",
                "OCP 8: Oracle Certified Professional Java Programmer",
                "One author two books : - Everything you need to know in OCP exam",
                45.00,
                true);
        booksAuthors = new BooksAuthors(book2, author);
        book2.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author);
        bookRepository.save(book1);
        bookRepository.save(book2);

        author = new Author("Al Sweigart");
        book = new Book("Python1004", "Automate the Boring Stuff with Python", "Fun with Python", 10.50, true);
        booksAuthors = new BooksAuthors(book, author);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author);
        bookRepository.save(book);

        author = new Author("Simon Monk");
        book = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, false);
        booksAuthors = new BooksAuthors(book, author);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author);
        bookRepository.save(book);

        author = new Author("Donald Norris");
        book = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true);
        booksAuthors = new BooksAuthors(book, author);
        book.getBooksAuthors().add(booksAuthors);
        authorRepository.save(author);
        bookRepository.save(book);
    }
}
