package org.example.to_do_list.repository;

import org.example.to_do_list.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository {
    private List<TodoItem> todoItems = new ArrayList<>();
    private Integer idCounter = 0;
    public List<TodoItem> fetchAllTodoItems () {
        if(todoItems.isEmpty()) {
            TodoItem item1 = new TodoItem();
            item1.setId(idCounter++);
            item1.setDone(false);
            item1.setTask("Task #1");
        }
        return todoItems;
    }
}
