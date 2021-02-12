package com.todo.dao;

import com.todo.model.Task;
import com.todo.model.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements TaskDAO and perform
 * CRUD operations. For this I use jdbcTemplate
 * which connected to the PostgreSql.
 * @author vlad-dvlad
 * @version 1.0
 * @since 2021-02-04
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

    private final String SQL_FIND_TASK = "SELECT * FROM task WHERE ID = ?";
    private final String SQL_DELETE_TASK = "DELETE FROM task WHERE ID = ?";
    private final String SQL_UPDATE_TASK = "UPDATE task SET TITLE = ?, " +
            "TASK_CATEGORY = ?, IS_COMPLETE = ?, IS_IMPORTANT = ? WHERE ID = ?";
    private final String SQL_GET_ALL = "SELECT * FROM task";
    private final String SQL_INSERT_TASK = "INSERT INTO task(ID, TITLE, TASK_CATEGORY, IS_COMPLETE, IS_IMPORTANT)" +
            " VALUES(?, ?, ?, ?, ?)"; // ЧЕКНУТИ ЧИ 4 ЧИ 5

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Deprecated
    @Override
    public Task getTaskById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_TASK, new Object[] { id }, new TaskMapper());
    }

    @Override
    public List<Task> getAllTask() {
        return jdbcTemplate.query(SQL_GET_ALL, new TaskMapper());
    }

    @Override
    public boolean deleteTask(Task task) {
        return jdbcTemplate.update(SQL_DELETE_TASK, task.getId()) > 0;
    }

    @Override
    public boolean updateTask(Task task) {
        return jdbcTemplate.update(SQL_UPDATE_TASK, task.getTitle(),
                task.getCategory(), task.getIsComplete(), task.getIsImportant(), task.getId()) > 0;
    }

    @Override
    public boolean createTask(Task task) {
        return jdbcTemplate.update(SQL_INSERT_TASK ,task.getId(), task.getTitle(),
                task.getCategory(), task.getIsComplete(), task.getIsImportant()) > 0;
    }
}
