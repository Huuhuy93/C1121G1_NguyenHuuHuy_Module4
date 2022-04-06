package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.catalogue.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICatalogueService iCatalogueService;

    @GetMapping("")
    public ModelAndView listCatalogue() {
        Iterable<Catalogue> catalogues = iCatalogueService.findAll();
        ModelAndView modelAndView = new ModelAndView("/catalogue/home");
        modelAndView.addObject("catalogues", catalogues);
        return modelAndView;
    }

    @GetMapping("/create-catalogue")
    public ModelAndView showCreateFormCatalogue() {
        ModelAndView modelAndView = new ModelAndView("/catalogue/create");
        modelAndView.addObject("catalogue", new Catalogue());
        return modelAndView;
    }

    @PostMapping("/create-catalogue")
    public ModelAndView saveCatalogue(@ModelAttribute("catalogue") Catalogue catalogue) {
        iCatalogueService.save(catalogue);

        ModelAndView modelAndView = new ModelAndView("/catalogue/create");
        modelAndView.addObject("catalogue", new Catalogue());
        modelAndView.addObject("message", "New catalogue created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-catalogue/{id}")
    public ModelAndView showEditFormCatalogue(@PathVariable Integer id) {
        Optional<Catalogue> catalogue = iCatalogueService.findById(id);
        if (catalogue.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/catalogue/edit");
            modelAndView.addObject("catalogue", catalogue.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-catalogue")
    public ModelAndView updateCatalogue(@ModelAttribute("catalogue") Catalogue catalogue) {
        iCatalogueService.save(catalogue);
        ModelAndView modelAndView = new ModelAndView("/catalogue/edit");
        modelAndView.addObject("catalogue", catalogue);
        modelAndView.addObject("message", "Catalogue updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-catalogue/{id}")
    public ModelAndView showDeleteFormCatalogue(@PathVariable Integer id) {
        Optional<Catalogue> catalogue = iCatalogueService.findById(id);
        if (catalogue.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/catalogue/delete");
            modelAndView.addObject("catalogue", catalogue.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-catalogue")
    public String deleteCatalogue(@ModelAttribute("catalogue") Catalogue catalogue) {
        iCatalogueService.remove(catalogue.getId());
        return "redirect:catalogues";
    }

    @GetMapping("/view-catalogue/{id}")
    public ModelAndView viewCatalogue(@PathVariable("id") Integer id){
        Optional<Catalogue> catalogueOptional = iCatalogueService.findById(id);
        if(!catalogueOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = iBlogService.findAllByCatalogue(catalogueOptional.get());

        ModelAndView modelAndView = new ModelAndView("/catalogue/view");
        modelAndView.addObject("catalogue", catalogueOptional.get());
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}
