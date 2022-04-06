package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public Iterable<Blog> findAll();

    public Optional<Blog> findById(Integer id);

    public void save(Blog blog);

    public void remove(int id);

    Iterable<Blog> findAllByCatalogue(Catalogue catalogue);
}
