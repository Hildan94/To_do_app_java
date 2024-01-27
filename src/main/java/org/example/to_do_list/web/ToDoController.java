package org.example.to_do_list.web;

import org.example.to_do_list.domain.TodoItem;
import org.example.to_do_list.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// hosted on http://localhost/8080
@RestController //listens for REST requests and sends a response
public class ToDoController {

    @Autowired
    private TodoService todoService;

    // fetch all todo Items
    @GetMapping("/api/todoItems")
    public ResponseEntity<?> fetchAllTodoItems () {
        List<TodoItem> todoItems = todoService.fetchAllTodoItems();
        return ResponseEntity.ok(todoItems);
    }
}
