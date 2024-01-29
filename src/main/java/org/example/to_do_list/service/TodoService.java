package org.example.to_do_list.service;

import org.example.to_do_list.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.example.to_do_list.domain.TodoItem;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepo;
    private Integer idCounter= 0;
    public Integer getIdCounter() {
        return idCounter;
    }
    public Integer giveIdCounter() {
        return ++idCounter;
    }

    public TodoService(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }
    public List<TodoItem> fetchAllTodoItems () {
        return todoRepo.fetchAllTodoItems();
    }

    public TodoItem createTodoItem (TodoItem todoItem) {
        List<TodoItem> todoItemList = fetchAllTodoItems();
        todoItem.setId(giveIdCounter());
        todoItemList.add(todoItem);
        return todoItem;
    }

    public TodoItem updateTodoItem (Integer id, TodoItem todoItem) {
        Optional<TodoItem> todoOpt = todoRepo.fetchAllTodoItems()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findAny();
        if(todoOpt.isPresent()) {
            TodoItem item = todoOpt.get();
            item.setTask(todoItem.getTask());
            item.setIsDone(todoItem.getIsDone());
            return item;
        }
        else {
            return null;
        }
    }

    public List<TodoItem> deleteTodoItem (Integer id) {
        todoRepo.fetchAllTodoItems()
                .removeIf(item -> item.getId().equals(id));
        Optional<TodoItem> todoOpt = todoRepo.fetchAllTodoItems()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findAny();
        return todoRepo.fetchAllTodoItems();
    }
}
