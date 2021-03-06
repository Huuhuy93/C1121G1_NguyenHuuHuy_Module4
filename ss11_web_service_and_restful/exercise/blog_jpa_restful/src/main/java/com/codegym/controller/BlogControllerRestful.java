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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogControllerRestful {
    @Autowired
    ICatalogueService iCatalogueService;

    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping(value = "detail/{id}")
    public ResponseEntity<Optional<Blog>> detailBlog(@PathVariable Integer id) {
        Optional<Blog> blog = this.iBlogService.findById(id);
        if (blog==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
