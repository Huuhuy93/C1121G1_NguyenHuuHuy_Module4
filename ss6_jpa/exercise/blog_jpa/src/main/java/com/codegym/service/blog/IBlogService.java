package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public Iterable<Blog> findAll();

    public Optional<Blog> findById(Integer id);

    public void save(Blog blog);

    public void remove(int id);

    Iterable<Blog> findAllByCatalogue(Catalogue catalogue);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByAuthorBlogContaining(String authorBlog, Pageable pageable);
}
