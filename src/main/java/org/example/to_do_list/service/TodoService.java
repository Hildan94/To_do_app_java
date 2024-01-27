package org.example.to_do_list.service;

import org.example.to_do_list.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.example.to_do_list.domain.TodoItem;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepo;
    public List<TodoItem> fetchAllTodoItems () {
        return todoRepo.fetchAllTodoItems();
    }
}
