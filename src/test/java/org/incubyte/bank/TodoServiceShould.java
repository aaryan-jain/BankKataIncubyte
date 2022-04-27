package org.incubyte.bank;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TodoServiceShould {
    @Inject
    Todo todo;
    @Mock
    TodoRepository todoRepository;

    @Test
    public void save_todo_object_in_database() {

        TodoService todoService = new TodoService(todoRepository);

        todoService.save(todo);

        Mockito.verify(todoRepository).save(todo);

    }

    @Test
    public void get_todo_object_by_id_from_database() {

        Todo todo=new Todo();
        todo.setDescription("jjj");
        todo.setState(false);

        TodoService todoService = new TodoService(todoRepository);
        todoService.getTodoByID(1L);

        Mockito.verify(todoRepository).findById(1L);


    }
}
