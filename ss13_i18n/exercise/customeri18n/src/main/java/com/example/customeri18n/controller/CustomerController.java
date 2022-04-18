package com.example.customeri18n.controller;

import com.example.customeri18n.model.Customer;
import com.example.customeri18n.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customers = this.iCustomerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        this.iCustomerService.save(customer);
        redirect.addFlashAttribute("msg", "add new customer successfully!");
        return "redirect:/customer";
    }
}
