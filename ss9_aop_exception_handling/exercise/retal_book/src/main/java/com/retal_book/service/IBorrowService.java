package com.retal_book.service;

import com.retal_book.model.Book;
import com.retal_book.model.Borrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBorrowService {
    public Iterable<Borrow> findAll();

    Page<Borrow> findAll(Pageable pageable);

    public void save(Borrow borrow);

    public Optional<Borrow> findById(Integer id);
}
