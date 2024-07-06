package com.example.todopractice.service.impl;

import com.example.todopractice.data.model.Todo;
import com.example.todopractice.repostitory.ToDoRepository;
import com.example.todopractice.request.ToDoRequest;
import com.example.todopractice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@Component("1")
public class TodoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public static final List<String> todoList = new ArrayList<>();

    @Override
    public String addAction(String action) {
        //khoi tao thuc the
        Todo todo = new Todo();

        //set du lieu
        todo.setToDoContext(action);
        todo.setToDoDate(new Date());

        //luu thuc the vao trong csdl
        toDoRepository.save(todo);
        return action;
    }

    @Override
    public List<String> getList() {
        return toDoRepository.findAll().stream().
                map(todo -> todo.getToDoContext()).collect(Collectors.toList());
    }

    //lay 1 san pham bang id
    @Override
    public Todo getDetails(Long id) throws Exception {
        return toDoRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
    }

    @Override
    public String delete(Long id) throws Exception {
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
        toDoRepository.delete(todo);
        return "Xoa thanh cong ID: " + id;
    }

    @Override
    public Todo update(Long id, ToDoRequest todoRequest) throws Exception {
        //lay du lieu tu db
        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new Exception("Loi o truong id"));
        //cap nhat du lieu tu nguoi dung
        todo.setToDoContext(todoRequest.getAction());
        todo.setToDoDate(new Date());
        //luu du lieu vao db
        return toDoRepository.save(todo);
    }

}
