package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/")
    public String listCourses(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("books", bookRepository.findAll()); //generate select * statement
        return "list";
    }

    @GetMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookform";
        }
        bookRepository.save(book);//generate SQL statement and insert into database
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "bookform";
    }

    @RequestMapping("/delete/{id}")
    public String delBook(@PathVariable("id") long id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delBooks(@RequestParam("check") long[] ids){
        for(long id : ids){
            bookRepository.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        return "about";
    }
}
