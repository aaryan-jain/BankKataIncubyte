package org.incubyte.bank;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoControllerShould {

    @Inject
    Todo todo;

    @Mock
    TodoService todoService;

    @Test
    public void save_a_todo_object_using_controller() {

        TodoController todoController = new TodoController(todoService);

        todoController.saveObject(todo);

        Mockito.verify(todoService).save(todo);

    }

    @Test
    public void get_a_todo_object_using_ID() {


        TodoController todoController = new TodoController(todoService);

        todoController.getObjectByID(10L);

        Mockito.verify(todoService).getTodoByID(10L);

    }


}
