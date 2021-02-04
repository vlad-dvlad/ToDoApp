package com.todo.dao;

import com.todo.model.Task;

import java.util.List;

/**
 * This interface contain all
 * CRUD operation for our Task/
 * @author vlad-dvlad
 * @version 1.0
 * @since 2021-02-04
 */

public interface TaskDAO {

    Task getTaskById(Long id);

    List<Task> getAllTask();

    boolean deleteTask(Task task);

    boolean updateTask(Task task);

    boolean createTask(Task task);
}
