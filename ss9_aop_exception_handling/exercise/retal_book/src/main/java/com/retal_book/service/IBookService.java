package com.retal_book.service;

import com.retal_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    public Iterable<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    public void save(Book book);

    public Optional<Book> findById(Integer id);
}
