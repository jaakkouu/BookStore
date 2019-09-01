package fi.haagahelia.courses.course.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.courses.course.model.BookRepository;
import fi.haagahelia.courses.course.model.CategoryRepository;
import fi.haagahelia.courses.course.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/add")
    public String buildBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") String id, Model model) {
        long bookId = Long.parseLong(id);
        if(bookRepository.existsById(bookId)) {
            Optional<Book> book = bookRepository.findById(bookId);
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("book", book);
        } 
        return "editbook";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id) {
        long bookId = Long.parseLong(id);
        if(bookRepository.findById(bookId) != null) {
            bookRepository.deleteById(bookId);
        }
        return "redirect:/booklist";
    }
    
}