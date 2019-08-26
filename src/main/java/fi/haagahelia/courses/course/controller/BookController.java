package fi.haagahelia.courses.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {

    @RequestMapping("/index")
    public String main(Model model) {
        return "index";
    }
}