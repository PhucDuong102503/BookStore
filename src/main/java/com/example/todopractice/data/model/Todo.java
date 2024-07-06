package com.example.todopractice.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "to_do_context")
    private String toDoContext;

    @Column(name = "to_do_date")
    private Date toDoDate;
}
