package fi.haagahelia.courses.course.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.courses.course.model.BookRepository;
import fi.haagahelia.courses.course.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/index")
    public String main() {
        return "book";
    }
    
    @RequestMapping("/add")
    public String buildBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") String id, Model model) {
        long bookId = Long.parseLong(id);
        if(repository.existsById(bookId)) {
            Optional<Book> book = repository.findById(bookId);
            model.addAttribute("book", book);
        } 
        return "editbook";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Book book){
        repository.save(book);
        return "redirect:/booklist";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id) {
        long bookId = Long.parseLong(id);
        if(repository.findById(bookId) != null) {
            repository.deleteById(bookId);
        }
        return "redirect:/booklist";
    }
    
}