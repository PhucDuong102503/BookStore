package com.example.bookstoreapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookStoreRequest {
    private Long id;
    private String title;
    private String description;
    private String author;
    private double price;
    private String bookImage;
    private String bookType;
    private boolean isLocked;
    private Date createAt;
}
