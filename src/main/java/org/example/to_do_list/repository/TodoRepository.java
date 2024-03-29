package org.example.to_do_list.repository;

import org.example.to_do_list.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    private List<TodoItem> todoItems = new ArrayList<>();
    private Integer idCounter = 0;

    public TodoRepository () {

    }
    public List<TodoItem> fetchAllTodoItems () {
        return todoItems;
    }
}
