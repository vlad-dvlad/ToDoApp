package com.todo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/** This class need for
 * fetching data from Database
 * @version 1.0
 * @since 2021-02-04
 * @author vlad-dvlad
 */
public class TaskMapper implements RowMapper<Task> {

    /**
     * This method get data from DB
     * @param rs entity, which stores data
     * @param rowNum is number of row in DB
     * @return - instance of model class (Task.class)
     * @throws SQLException - exception, which help perform
     * SQL operations
     */
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setCategory(rs.getString("task_category"));
        task.setIsComplete(rs.getBoolean("is_complete"));
        task.setIsImportant(rs.getBoolean("is_important"));
        return task;
    }
}
