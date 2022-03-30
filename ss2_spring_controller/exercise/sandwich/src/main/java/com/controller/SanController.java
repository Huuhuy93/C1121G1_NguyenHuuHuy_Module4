package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SanController {

    @GetMapping(value = "/sandwich")
    public String listCondiment() {
        return "home";
    }

    @PostMapping(value = "/sandwich")
    public String result(@RequestParam(value = "condiment", required = false, defaultValue = "Nothing") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "condiment";
    }
}
