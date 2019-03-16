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
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        //one book one author
        Author author = new Author("Bruce Eckel");
        Book book = new Book("Java1002", "Thinking in Java", "One Author one Book : - Details about Java under the hood", 20.00, true);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);

        //Two authors one book
        Set<Author> authors = new HashSet<>();
        author = new Author("Kathy Sierra");
        authors.add(author);
        authorRepository.save(author);
        author = new Author("Bert Bates");
        authors.add(author);
        book = new Book("Java1001", "Head First Java","Two authors one book: - Easy to read Java workbook", 47.50, true);
        book.setAuthors(authors);
        authorRepository.save(author);
        bookRepository.save(book);

        //one author two books
        author = new Author("Jeanne Boyarsky");
        Set<Book> books = new HashSet<>();
        Book book1 = new Book("Orcl1003", "OCA: Oracle 8 Certified Associate Java SE", "One author two books : - Everything you need to know in one place", 45.00, true);
        book1.getAuthors().add(author);
        books.add(book1);
        Book book2 = new Book("Orcl1004", "OCP: Oracle 8 Certified Professional Java SE", "One author two books : - Everything you need to know in one place", 45.00, true);
        book2.getAuthors().add(author);
        books.add(book2);
        author.setBooks(books);
        authorRepository.save(author);
        bookRepository.save(book1);
        bookRepository.save(book2);

        author = new Author("Al Sweigart");
        book = new Book("Python1004", "Automate the Boring Stuff with Python",  "Fun with Python", 10.50, true);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);

        author = new Author("Simon Monk");
        book = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse",  "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, false);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);

        author = new Author("Donald Norris");
        book = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true);
        book.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(book);
    }
}
