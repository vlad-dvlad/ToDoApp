package com.todo.dao;

import com.todo.model.Task;

import java.util.List;

public interface TaskDAO {

    Task getTaskById(Long id);

    List<Task> getAllTask();

    boolean deleteTask(Task task);

    boolean updateTask(Task task);

    boolean createTask(Task task);
}
