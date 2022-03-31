package com.controller;

import com.model.Medical;
import com.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MedicalController {

    @Autowired
    IMedicalService iMedicalService;

    @GetMapping(value = "/medicalList")
    public ModelAndView showMedical(Model model) {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Medical> medicalList = this.iMedicalService.findAll();
        List<String> phuongTienList = this.iMedicalService.findQuocTich();
        modelAndView.addObject("medicalList", medicalList);
        modelAndView.addObject("phuongTienList", phuongTienList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView goCreateMedical(Model model) {
        ModelAndView modelAndView = new ModelAndView("create_medical");
        Medical medical = new Medical();
        List<String> phuongTienList = this.iMedicalService.findQuocTich();
        modelAndView.addObject("medical", medical);
        modelAndView.addObject("phuongTienList", phuongTienList);
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createMedical(@ModelAttribute Medical medical, Model model) {
        this.iMedicalService.save(medical);
        return "redirect:/medicalList";
    }
}
