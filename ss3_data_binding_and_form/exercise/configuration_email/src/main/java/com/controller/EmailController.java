package com.controller;

import com.model.Email;
import com.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    IEmailService iEmailService;

    @GetMapping(value = "/email")
    public ModelAndView showEmail(Model model) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Email> emailList = this.iEmailService.findAll();
        String[] languageList = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
        modelAndView.addObject("emailList", emailList);
        modelAndView.addObject("languageList", languageList);
        modelAndView.addObject("pageSizeList", pageSizeList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView goCreateEmail(Model model) {
        ModelAndView modelAndView = new ModelAndView("create_email");
        Email email = new Email();
        String[] languageList = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = new Integer[]{5, 10, 15, 25, 50, 100};
        modelAndView.addObject("email", email);
        modelAndView.addObject("languageList", languageList);
        modelAndView.addObject("pageSizeList", pageSizeList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createEmail(@ModelAttribute Email email, Model model) {
        this.iEmailService.save(email);

        return "redirect:/email";
    }
}
