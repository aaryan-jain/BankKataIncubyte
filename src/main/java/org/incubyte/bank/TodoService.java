package org.incubyte.bank;

import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodoByID(long id) {
       return todoRepository.findById(id);
//        throw new UnsupportedOperationException();
    }

}
