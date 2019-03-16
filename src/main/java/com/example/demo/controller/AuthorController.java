package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorRepository;
import com.example.demo.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthorController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/authorlist")
    public String listCourses(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("books", bookRepository.findAll()); //generate select * statement
        return "authorlist";
    }

    @GetMapping("/addauthor")
    public String authorForm(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "authorform";
    }

    @PostMapping("/processauthor")
    public String processSubject(@Valid Author author, BindingResult result,
                                 Model model){
        if(result.hasErrors()){
            return "authorform";
        }
        if(authorRepository.findByName(author.getName()) != null){
            model.addAttribute("message", "You already have a subject called " +
                    author.getName() + "!" + " Try something else.");
            return "authorform";
        }
        authorRepository.save(author);
        return "redirect:/";
    }
}
