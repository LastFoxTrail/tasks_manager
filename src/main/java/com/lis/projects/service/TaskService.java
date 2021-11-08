package com.lis.projects.service;

import com.lis.projects.model.Task;
import java.util.List;

public interface TaskService<T> {
    List<T> get() throws Exception;
    Task getById(int id) throws Exception;
    void add(T task) throws Exception;
    void update(T task) throws Exception;
    void delete(int id) throws Exception;
}
