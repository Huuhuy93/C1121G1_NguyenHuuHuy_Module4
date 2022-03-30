package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalController {

    @GetMapping(value = "/cal")
    public String showCalculator() {
        return "home";
    }

    @PostMapping(value = "/cal")
    public String calculator(@RequestParam String operator, @RequestParam Double firstOperand,
                             @RequestParam Double secondOperand, Model model) {

        Double result = 0.0;
        switch (operator) {
            case "+":
                model.addAttribute("result",firstOperand + secondOperand);
                break;
            case "-":
                model.addAttribute("result",firstOperand - secondOperand);
                break;
            case "*":
                model.addAttribute("result",firstOperand * secondOperand);
                break;
            case "/":
                if(secondOperand != 0)
                    model.addAttribute("result",firstOperand / secondOperand);
                else
                    model.addAttribute("result", "Can't divide by zero");
                break;

        }

        return "home";
    }
}
