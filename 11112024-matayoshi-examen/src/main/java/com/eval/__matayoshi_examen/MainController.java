package com.eval.__matayoshi_examen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Evaluación");
        return "home";
    }
}