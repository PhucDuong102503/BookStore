package com.example.bookstoreapp.rest;

import com.example.bookstoreapp.data.model.Book;
import com.example.bookstoreapp.request.BookStoreRequest;
import com.example.bookstoreapp.services.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/v1")
public class BookStoreRest {
    @Qualifier("1")
    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping("list-book")
    public List<BookStoreRequest> listBook() {
    return bookStoreService.getListBook();
    }

    //them sach vao bang book
    @PostMapping("add-book")
    public void addBook(@RequestBody BookStoreRequest request) throws Exception {
       bookStoreService.addBook(request);
    }

    //lay san pham bang id
    @GetMapping("detail/{id}")
    public Book getBookByID(@PathVariable(name = "id") Long id) throws Exception {
        return bookStoreService.getProductByID(id);
    }

    //xoa san pham bang id
    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable(name = "id") Long id) throws Exception {
        bookStoreService.deleteProductByID(id);
    }

    //update sp bang id
    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable(name = "id") Long id, @RequestBody BookStoreRequest request) throws Exception {
        return bookStoreService.updateProductByID(id, request);
    }

    @GetMapping("search/{title}")
    public List<BookStoreRequest> searchBook(@PathVariable(name = "title") String title) {
        try {
            return bookStoreService.searchProductByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
