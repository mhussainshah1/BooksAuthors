package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    BookRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Kathy Sierra");
        author = new Author("Bert Bates");
        Book book = new Book("Java1001", "Head First Java","Easy to read Java workbook", 47.50, true);
        repository.save(book);

        author = new Author("Bruce Eckel");
        book = new Book("Java1002", "Thinking in Java", "Details about Java under the hood", 20.00, true);
        repository.save(book);

        author = new Author("Jeanne Boyarsky");
        book = new Book("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Everything you need to know in one place", 45.00, true);
        repository.save(book);

        author = new Author("Al Sweigart");
        book = new Book("Python1004", "Automate the Boring Stuff with Python",  "Fun with Python", 10.50, true);
        repository.save(book);

        author = new Author("Simon Monk");
        book = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse",  "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, false);
        repository.save(book);

        author = new Author("Donald Norris");
        book = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, true);
        repository.save(book);
    }
}
