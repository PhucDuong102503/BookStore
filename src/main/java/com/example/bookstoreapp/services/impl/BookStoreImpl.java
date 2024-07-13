package com.example.bookstoreapp.services.impl;

import com.example.bookstoreapp.data.model.Book;
import com.example.bookstoreapp.repository.BookStoreRepository;
import com.example.bookstoreapp.request.BookStoreRequest;
import com.example.bookstoreapp.services.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@Component("1")
public class BookStoreImpl implements BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Override
    @Transactional
    public void addBook(BookStoreRequest request) {
        // khoi tao thuc the
        Book book = new Book();

        //set du lieu
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setBookImage(request.getBookImage());
        book.setBookType(request.getBookType());

        //lu du lieu vao csdl
        bookStoreRepository.save(book);
    }

    @Override
    public List<BookStoreRequest> getListBook() {
        return bookStoreRepository.findAll().stream().map(book ->
                new BookStoreRequest(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getBookImage(),
                        book.getBookType(),
                        book.isLocked(),
                        book.getCreateAt())).toList();
    }

    @Override
    public Book getProductByID(Long id) throws Exception {
        return bookStoreRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
    }

    @Override
    public void deleteProductByID(Long id) throws Exception {
        Book book = bookStoreRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
        bookStoreRepository.delete(book);
    }

    @Override
    public Book updateProductByID(Long id, BookStoreRequest request) throws Exception {
        Book book = bookStoreRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setBookImage(request.getBookImage());
        book.setBookType(request.getBookType());
        book.setLocked(request.isLocked());
        book.setCreateAt(request.getCreateAt());
        return bookStoreRepository.save(book);
    }

    @Override
    public List<BookStoreRequest> searchProductByTitle(String title) throws Exception {
        List<Book> books = bookStoreRepository.findByTitle(title);
        return books.stream()
                .map(book -> new BookStoreRequest(
                        book.getId(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getBookImage(),
                        book.getBookType(),
                        book.isLocked(),
                        book.getCreateAt()
                        )).toList();
    }


}
