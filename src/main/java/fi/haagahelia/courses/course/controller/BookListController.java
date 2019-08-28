package fi.haagahelia.courses.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.courses.course.model.BookRepository;

@Controller
public class BookListController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/booklist")
    public String main(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}