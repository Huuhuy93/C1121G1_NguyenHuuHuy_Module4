package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping(value = {""})
    public String goConvert() {
        return "menu";
    }

    @PostMapping(value = {"/convert"})
    public String convert(@RequestParam double rate, @RequestParam double usd, Model model) {
        double vnd = this.iConvertService.convert(rate, usd);
        model.addAttribute("vnd", vnd);

        return "result_convert";
    }

}
