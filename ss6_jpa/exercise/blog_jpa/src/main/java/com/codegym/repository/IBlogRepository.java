package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findAllByCatalogue(Catalogue catalogue);
}
