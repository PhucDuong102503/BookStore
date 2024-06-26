package com.example.todoapp.contronller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controller/todo")
public class TodoActionController {
    @PostMapping()
    public String todoAppAction(Model model, @RequestParam(name = "actionName", required = false, defaultValue = "Input ToDo in hear") String actionName){
        model.addAttribute("actionName", actionName);
        return "todo";
    }

//    @PostMapping()
//    public String todoAppDate(Model model, @RequestParam(name = "actionDate", required = false, defaultValue = "Input ToDo in hear") String actionDate){
//        model.addAttribute("date", actionDate);
//        return "todo";
//    }
}
