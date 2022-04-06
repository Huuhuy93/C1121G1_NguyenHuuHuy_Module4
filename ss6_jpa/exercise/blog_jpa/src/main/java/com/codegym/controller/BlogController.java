package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.catalogue.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICatalogueService iCatalogueService;

    @ModelAttribute("catalogues")
    public Iterable<Catalogue> catalogues() {
        return iCatalogueService.findAll();
    }

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogCreate", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("success", "Add blog successfully!");
        return "redirect:/blog";
    }

//    @GetMapping("/{id}/edit")
//    public String showEdit(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("blogEdit", iBlogService.findById(id));
//        return "/blog/edit";
//    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
//        iBlogService.save(blog);
//        redirect.addFlashAttribute("success", "Update blog successfully!");
//        return "redirect:/blog";
//    }

    @PostMapping("/update")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("success", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("blogDelete", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blogView", iBlogService.findById(id).get());
        return "/blog/view";
    }
}
