package com.example.todopractice.rest;

import com.example.todopractice.data.model.Todo;
import com.example.todopractice.request.ToDoRequest;
import com.example.todopractice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/v1")
public class ToDoRest {
    @Qualifier("1")
    @Autowired
    private ToDoService todoService;

    //them gia tri vao bang
    @PostMapping("add-to-do")
    public String action(@RequestParam(name = "action") String action) {
        return todoService.addAction(action);
    }

    //lay ra tat ca cac phan tu trong bang
    @GetMapping("to-do-list")
    public List<String> listAction() {
        return todoService.getList();
    }

    //lay 1 san pham bang id
    @GetMapping("detail/{id}")
    public Todo listAction(@PathVariable(name = "id") Long id) throws Exception {
        return todoService.getDetails(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteAction(@PathVariable(name = "id") Long id) throws Exception{
        return todoService.delete(id);
    }

    @PutMapping("update/{id}")
    public Todo updateAction(@PathVariable(name = "id") Long id, @RequestBody ToDoRequest todoRequest) throws Exception{
        return todoService.update(id, todoRequest);
    }
}
