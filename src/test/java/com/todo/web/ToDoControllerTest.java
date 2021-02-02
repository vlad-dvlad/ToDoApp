package com.todo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.dao.TaskDAO;
import com.todo.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class ToDoControllerTest {

    @Mock
    TaskDAO taskDAO;

    @InjectMocks
    public ToDoController toDoController;

    private ObjectMapper mapper;

    @Test
    public void createTask() throws Exception {
        Task task = new Task(2L, "swimming", "workout", false, true);

        mapper = new ObjectMapper();
        String jsonCreate = mapper.writeValueAsString(task);

        MockMvc createTask = standaloneSetup(toDoController).build();
        createTask.perform(post("/app/todo/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCreate))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void getTask() throws Exception {
        MockMvc getTaskById = standaloneSetup(toDoController).build();
        getTaskById.perform(get("/app/todo/?/")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    public void updateTask() throws Exception {
        Task task = new Task(4L, "cooking", "home", false, true);

        mapper = new ObjectMapper();
        String jsonUpdate = mapper.writeValueAsString(task);

        MockMvc updateTask = standaloneSetup(toDoController).build();
        updateTask.perform(put("/app/todo/?/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUpdate))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void deleteTask() throws Exception {
        MockMvc deleteTask = standaloneSetup(toDoController).build();
        deleteTask.perform(delete("/app/todo/?/")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    public void getAll() throws Exception {
        MockMvc getAll = standaloneSetup(toDoController).build();
        getAll.perform(get("/app/todo/")
            .accept(MediaType.APPLICATION_JSON))
            .andReturn();
    }
}