package com.example.todopractice.service;

import com.example.todopractice.data.model.Todo;
import com.example.todopractice.request.ToDoRequest;

import java.util.List;

public interface ToDoService {

    String addAction(String action);

    List<String> getList();

    Todo getDetails(Long id) throws Exception;

    String delete(Long id) throws Exception;

    Todo update(Long id, ToDoRequest todoRequest) throws Exception;
}
