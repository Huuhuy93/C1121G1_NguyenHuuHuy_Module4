package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public List<Blog> findAll();

    public Optional<Blog> findById(Integer id);

    public void save(Blog blog);

    public void remove(int id);
}
