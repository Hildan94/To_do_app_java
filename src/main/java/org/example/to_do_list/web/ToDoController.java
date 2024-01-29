package org.example.to_do_list.web;

import org.example.to_do_list.domain.TodoItem;
import org.example.to_do_list.service.TodoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// hosted on http://localhost/8080
@RestController //listens for REST requests and sends a response
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

    private TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // fetch all todo Items
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems () {
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();
        return ResponseEntity.ok(todoItems);
    }

    @PostMapping("/api/todoItems/todoItem")
    public ResponseEntity<?> createTodoItem ( @RequestBody TodoItem todoItem) {
        System.out.println("the received todo is " + todoItem.getId());
        TodoItem createdTodoItem = todoService.createTodoItem(todoItem);
        System.out.println("the created todo is " + todoItem.getId());
        return ResponseEntity.ok(createdTodoItem);
    }

    @PutMapping("/api/todoItems/{id}")
    public ResponseEntity<?> updateTodoItem (@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        System.out.println("the received task is " + todoItem.toString());
        TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);
        return ResponseEntity.ok(updatedTodoItem);
    }

    @DeleteMapping("/api/todoItems/{id}")
    public ResponseEntity<?> deleteTodoItem (@PathVariable Integer id) {
        System.out.println("the received task to delete is " + id.toString());
        List<TodoItem> updatedList = todoService.deleteTodoItem(id);
        return ResponseEntity.ok(updatedList);
    }
}
