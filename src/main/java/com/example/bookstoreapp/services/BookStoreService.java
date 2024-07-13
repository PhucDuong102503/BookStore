package com.example.bookstoreapp.services;

import com.example.bookstoreapp.data.model.Book;
import com.example.bookstoreapp.request.BookStoreRequest;

import java.util.List;

public interface BookStoreService {
    void addBook(BookStoreRequest request);

    List<BookStoreRequest> getListBook();

    Book getProductByID(Long id) throws Exception;

    void deleteProductByID(Long id) throws Exception;

    Book updateProductByID(Long id, BookStoreRequest request) throws Exception;

    List<BookStoreRequest> searchProductByTitle(String title) throws Exception;
}
