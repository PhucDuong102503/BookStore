package com.example.bookstoreapp.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private double price;

    @Column(name = "book_image")
    private String bookImage;

    @Column(name = "book_type")
    private String bookType;

    @Column(name = "is_locked")
    private boolean isLocked;

    @Column(name = "create_at")
    private Date createAt;
}
