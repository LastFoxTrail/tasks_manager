package com.lis.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lis.projects.dao.TaskDaoImpl;
import com.lis.projects.model.Task;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService<Task> {
    private static final Logger LOGGER = Logger.getLogger(TaskServiceImpl.class);
    private final TaskDaoImpl TASK_DAO;

    @Autowired
    public TaskServiceImpl(TaskDaoImpl taskDao) {
        this.TASK_DAO = taskDao;
    }

    @Override
    public List<Task> get() throws Exception {
        try {
            List<Task> tasks = TASK_DAO.get();
            LOGGER.info("IN get: data loaded successfully");
            return tasks;

        } catch (Exception e) {
            LOGGER.error("IN get: data retrieval error");
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public Task getById(int id) throws Exception {
        try {
            Task task = TASK_DAO.getById(id);
            LOGGER.info("IN getById: task with id="+ id +" successfully received");
            return task;

        } catch (Exception e) {
            LOGGER.error("IN getById: error loading task with id="+ id);
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void add(Task task) throws Exception {
        try {
            TASK_DAO.add(task);
            LOGGER.info("IN add: task with id="+ task.getId() +" successfully added");

        } catch (Exception e) {
            LOGGER.error("IN add: task adding error. Task id="+ task.getId());
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void update(Task task) throws Exception {
        try {
            TASK_DAO.update(task);
            LOGGER.info("IN update: task with id="+ task.getId() +" successfully updated");

        } catch (Exception e) {
            LOGGER.error("IN update: task update error. Task id="+ task.getId());
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            TASK_DAO.delete(id);
            LOGGER.info("IN delete: task with id=" + id + " successfully deleted");

        } catch(Exception e) {
            LOGGER.error("IN delete: task delete error. Task id="+ id);
            throw new SQLException(e.getMessage());
        }
    }
}
