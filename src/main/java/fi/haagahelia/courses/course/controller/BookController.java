package fi.haagahelia.courses.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.courses.course.dao.BookRepository;
import fi.haagahelia.courses.course.dao.CategoryRepository;
import fi.haagahelia.courses.course.model.Book;


@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/book/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping({"/", "/booklist"})
    public String list(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/book/{id}")
    public String view(@PathVariable Long id, Model model) {
        if(bookRepository.existsById(id)) {
            Book book = bookRepository.findById(id).get();
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("book", book);
        } 
        return "book";
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> restBooks() {
        return (List<Book>) bookRepository.findAll();
    }
 
    @GetMapping("/book/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        if(bookRepository.existsById(id)) {
            Book book = bookRepository.findById(id).get();
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("book", book);
        } 
        return "editbook";
    }

    @PostMapping("/book/update")
    public String update(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping("/book/add")
    public String create(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/book/{id}/delete")
    public String delete(@PathVariable Long id) {
        if(bookRepository.findById(id) != null) {
            bookRepository.deleteById(id);
        }
        return "redirect:/";
    }
    
}