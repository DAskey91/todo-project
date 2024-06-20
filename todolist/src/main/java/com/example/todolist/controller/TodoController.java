package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @PostMapping("/todos")
    public String addTodo(@RequestParam String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/todos/{id}/complete")
    public String completeTodo(@PathVariable Long id) {
        todoRepository.findById(id).ifPresent(todo -> {
            todo.setCompleted(true);
            todoRepository.save(todo);
        });
        return "redirect:/";
    }

    @PostMapping("/todos/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}
