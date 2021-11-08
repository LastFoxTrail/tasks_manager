package com.lis.projects.dao;

import com.lis.projects.model.Task;
import com.lis.projects.util.TasksRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao<Task> {
    private final JdbcTemplate JDBC_TEMPLATE;

    @Autowired
    public TaskDaoImpl(DataSource dataSource) {
        JDBC_TEMPLATE = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Task> get() {

        return JDBC_TEMPLATE.query("SELECT * FROM tasks", new TasksRowMapper());
    }

    @Override
    public Task getById(int id) {

        return JDBC_TEMPLATE.query(
                "SELECT * FROM tasks WHERE id=?", new Object[] {id}, new TasksRowMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void add(Task task) {

        JDBC_TEMPLATE.update(
                "INSERT INTO tasks(title, text, dead_line, date_of_change) values (?, ?, ?, ?)",
                task.getTitle(),
                task.getText(),
                task.getDeadLine(),
                task.getDateOfChange());
    }

    @Override
    public void update(Task task) {

        JDBC_TEMPLATE.update(
                "UPDATE tasks SET title=?, text=?, dead_line=?, date_of_change=? where id=?",
                task.getTitle(),
                task.getText(),
                task.getDeadLine(),
                task.getDateOfChange(),
                task.getId());
    }

    @Override
    public void delete(int id) {

        JDBC_TEMPLATE.update("DELETE FROM tasks WHERE id=?", id);
    }
}