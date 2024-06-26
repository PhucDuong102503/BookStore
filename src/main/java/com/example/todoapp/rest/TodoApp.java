package com.example.todoapp.rest;

import com.example.todoapp.request.TodoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TodoApp {

    @PostMapping("/get-todo")
    public String helloToDo(@RequestBody TodoRequest request) {
        return  request.getActionTodo() + "Date: " + request.getTime() + "...";
    }
}
