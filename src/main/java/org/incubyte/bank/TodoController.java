package org.incubyte.bank;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/")
public class TodoController {
    @Inject
    TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Post("/todoList")
    public Todo saveObject(Todo todo) {
       return todoService.save(todo);
    }

    @Get("/getTodoByID/{id}")
    public Optional<Todo> getObjectByID(@PathVariable long id) {
        return todoService.getTodoByID(id);
    }
}
