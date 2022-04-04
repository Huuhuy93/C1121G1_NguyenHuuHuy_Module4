package com.controller;

import com.model.Picture;
import com.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    private IPictureService iPictureService;

    @GetMapping("")
    public String showPicture(Model model) {
        List<Picture> pictureList = iPictureService.findAll();
        model.addAttribute("pictureList", pictureList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pictureCreate", new Picture());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Picture picture) {
        iPictureService.save(picture);
        return "redirect:/picture";
    }
}
