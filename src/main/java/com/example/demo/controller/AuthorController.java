package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthorController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BooksAuthorsRepository booksAuthorsRepository;

    @RequestMapping("/authorlist")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("booksauthors",booksAuthorsRepository);
        return "authorslist";
    }

    @GetMapping("/addauthor")
    public String authorForm(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("authors", authorRepository.findAll());
        return "authorform";
    }

    @PostMapping("/processauthor")
    public String processAuthor(@Valid Author author, BindingResult result,
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
        return "redirect:/authorlist";
    }

    @RequestMapping("/detailauthor/{id}")
    public String showAuthor(@PathVariable("id") long id, Model model) {
        model.addAttribute("author", authorRepository.findById(id).get());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("authorbooks", booksAuthorsRepository.findAllByAuthor_Id(id));
        return "authorlist";
    }

    @RequestMapping("/updateauthor/{id}")
    public String updateAuthor(@PathVariable("id") long id, Model model) {
        model.addAttribute("author", authorRepository.findById(id).get());
        return "authorform";
    }

    @RequestMapping("/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable("id") long id){
        authorRepository.deleteById(id);
        return "redirect:/authorlist";
    }

    @RequestMapping("/deleteauthor")
    public String deleteAuthors(@RequestParam("check") long[] ids){
        for(long id : ids){
            authorRepository.deleteById(id);
        }
        return "redirect:/authorlist";
    }
}
