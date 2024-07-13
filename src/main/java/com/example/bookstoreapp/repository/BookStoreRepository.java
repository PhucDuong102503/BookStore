package com.example.bookstoreapp.repository;

import com.example.bookstoreapp.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository  extends JpaRepository<Book, Long> {
    @Query("Select b from Book  b where b.title = :titleBook")
    List<Book> findByTitle(@Param("titleBook") String titleBook);
}
