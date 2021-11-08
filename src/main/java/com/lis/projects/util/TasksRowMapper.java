package com.lis.projects.util;

import com.lis.projects.model.Task;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TasksRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();

        task.setId(resultSet.getInt("id"));
        task.setTitle(resultSet.getString("title"));
        task.setText(resultSet.getString("text"));
        task.setDeadLine(resultSet.getString("dead_line"));
        task.setDateOfChange(resultSet.getDate("date_of_change"));

        return task;
    }
}
