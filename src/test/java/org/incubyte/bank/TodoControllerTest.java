package org.incubyte.bank;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class TodoControllerTest {
    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void create_todo_object_with_state_as_not_done_in_database(){

        Todo todo = new Todo();

        todo.setDescription("Mujhe Raat Me Jaldi Sona Hai!");
        todo.setState(false);

        Todo recievedObject =
                httpClient.toBlocking()
                        .retrieve(HttpRequest.POST("/todoList", todo), Argument.of(Todo.class));


        Assertions.assertThat(recievedObject.getDescription()).isEqualTo("Mujhe Raat Me Jaldi Sona Hai!");
        Assertions.assertThat(recievedObject.isState()).isFalse();
        Assertions.assertThat(recievedObject.getId()).isGreaterThan(0);

    }

    @Test
    public void recieve_todo_object_by_giving_ID(){

        Todo todo = new Todo();

        todo.setDescription("AAJ NAHANA HAI");
        todo.setState(false);

        Todo recievedObject =
                httpClient.toBlocking()
                        .retrieve(HttpRequest.POST("/todoList", todo), Argument.of(Todo.class));


        Todo recievedObjectByID =
                httpClient.toBlocking()
                        .retrieve(HttpRequest.GET("/getTodoByID/"+recievedObject.getId()), Argument.of(Todo.class));

        Assertions.assertThat(recievedObjectByID.getId()).isEqualTo(recievedObject.getId());

    }

}
