package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.catalogue.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Blob;
import java.util.List;

@RestController
@RequestMapping("/api/catalogues")
public class CatalogueControllerRestful {
    @Autowired
    ICatalogueService iCatalogueService;

    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Iterable<Catalogue>> findAllCatalogue() {
        List<Catalogue> catalogues = (List<Catalogue>) iCatalogueService.findAll();
        if (catalogues.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(catalogues, HttpStatus.OK);
    }

    @GetMapping(value = "detail/{id}")
    public ResponseEntity<List<Blog>> detailCatalogues(@PathVariable Integer id) {
        List<Blog> blogs = iBlogService.findAllByCatalogue(id);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
