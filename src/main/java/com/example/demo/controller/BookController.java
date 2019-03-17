package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BooksAuthorsRepository booksAuthorsRepository;

    @RequestMapping("/")
    public String listCourses(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("books", bookRepository.findAll()); //generate select * statement
        model.addAttribute("booksauthors",booksAuthorsRepository);
        return "list";
    }

    @GetMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.findAll());
        return "bookform";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("book") Book book,
                              BindingResult result,
                              @RequestParam("booksauthors") long[] ids,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authors", authorRepository.findAll());
            return "bookform";
        }

        for(long id : ids){
            Author author = authorRepository.findById(id).get();
            BooksAuthors booksAuthors = new BooksAuthors(book,author);
            bookRepository.save(book);//generate SQL statement and insert into database
            booksAuthorsRepository.save(booksAuthors);
        }

        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("authors", authorRepository.findAll());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        model.addAttribute("authors", authorRepository.findAll());
        return "bookform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String deleteBooks(@RequestParam("check") long[] ids){
        for(long id : ids){
            bookRepository.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "about";
    }
}
