package com.example.todolist.repository;

import com.example.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
//public class TodoRepository {
//    private List<Todo> todos = new ArrayList<>();
//    private AtomicLong counter = new AtomicLong();
//
//    public List<Todo> findAll() {
//        return todos;
//    }
//
//    public Optional<Todo> findById(Long id) {
//        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
//    }
//
//    public Todo save(Todo todo) {
//        if (todo.getId() == null) {
//            todo.setId(counter.incrementAndGet());
//        }
//        todos.add(todo);
//        return todo;
//    }
//
//    public void deleteById(Long id) {
//        todos.removeIf(todo -> todo.getId().equals(id));
//    }
//}
