package com.feedo.presenter_web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ViewController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
