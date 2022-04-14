package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blogs where catalogue_id = ?1", nativeQuery = true)
    List<Blog> findAllByCatalogue(Integer id);

    Page<Blog> findAllByAuthorBlogContaining(String authorBlog, Pageable pageable);
}
