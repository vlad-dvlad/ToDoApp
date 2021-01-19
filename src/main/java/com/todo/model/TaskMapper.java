package com.todo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setName(rs.getString("title"));
        task.setCategory(rs.getString("task_category"));
        task.setIsComplete(rs.getBoolean("is_complete"));
        task.setIsImportant(rs.getBoolean("is_important"));
        return task;
    }
}
