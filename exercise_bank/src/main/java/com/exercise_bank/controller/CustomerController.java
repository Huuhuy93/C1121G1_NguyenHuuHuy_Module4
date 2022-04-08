package com.exercise_bank.controller;

import com.exercise_bank.dto.CustomerDto;
import com.exercise_bank.dto.SavingDto;
import com.exercise_bank.model.Customer;
import com.exercise_bank.model.Saving;
import com.exercise_bank.service.ICustomerService;
import com.exercise_bank.service.ISavingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ISavingService iSavingService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "/customer/home";
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveForm(@Valid @ModelAttribute CustomerDto customerDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Sucess Create Customer!!!");
        return "redirect:/customer";
    }
}
