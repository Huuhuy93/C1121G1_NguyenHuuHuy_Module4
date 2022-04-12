package com.retal_book.repository;

import com.retal_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update book set quantity = quantity - 1 where id_book = :id_book", nativeQuery = true)
    void borrow(@Param("id") Integer id);
}
