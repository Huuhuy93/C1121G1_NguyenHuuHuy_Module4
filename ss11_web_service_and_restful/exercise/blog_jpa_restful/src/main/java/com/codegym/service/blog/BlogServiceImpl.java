package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }


    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() == null){
            blog.setCreateTime(String.valueOf(LocalDateTime.now()));
            iBlogRepository.save(blog);
        } else {
            iBlogRepository.save(blog);
        }
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByCatalogue(Integer id) {
        return iBlogRepository.findAllByCatalogue(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByAuthorBlogContaining(String authorBlog, Pageable pageable) {
        return iBlogRepository.findAllByAuthorBlogContaining(authorBlog, pageable);
    }
}
