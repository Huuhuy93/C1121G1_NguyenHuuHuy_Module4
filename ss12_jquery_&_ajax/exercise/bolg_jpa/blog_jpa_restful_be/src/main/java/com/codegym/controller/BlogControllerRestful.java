package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.catalogue.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogControllerRestful {
    @Autowired
    ICatalogueService iCatalogueService;

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Blog>> findAllBlog(@PageableDefault(value = 2) Pageable pageable,
                                                      @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");

        Page<Blog> blogs = this.iBlogService.findAllByAuthorBlogContaining(keywordValue, pageable);
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

    @PostMapping("/create")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
        this.iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        blog.setId(blogOptional.get().getId());
        Catalogue catalogue = new Catalogue();
        catalogue.setId(blogOptional.get().getCatalogue().getId());
        blog.setCatalogue(catalogue);
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
