package com.retal_book.service.impl;

import com.retal_book.model.Book;
import com.retal_book.model.Borrow;
import com.retal_book.repository.IBorrowRepository;
import com.retal_book.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    IBorrowRepository iBorrowRepository;

    @Override
    public Iterable<Borrow> findAll() {
        return iBorrowRepository.findAll();
    }

    @Override
    public Page<Borrow> findAll(Pageable pageable) {
        return iBorrowRepository.findAll(pageable);
    }

    @Override
    public void save(Borrow borrow) {
        iBorrowRepository.save(borrow);
    }

    @Override
    public Optional<Borrow> findById(Integer id) {
        return iBorrowRepository.findById(id);
    }
}
