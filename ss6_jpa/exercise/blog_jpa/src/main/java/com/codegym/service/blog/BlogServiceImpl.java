package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Catalogue;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Iterable<Blog> findAllByCatalogue(Catalogue catalogue) {
        return iBlogRepository.findAllByCatalogue(catalogue);
    }
}
