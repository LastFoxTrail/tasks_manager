package com.lis.projects.dao;

import com.lis.projects.model.Task;
import java.util.List;

public interface TaskDao<T> {
    List<T> get();
    Task getById(int id);
    void add(T task);
    void update(T task);
    void delete(int id);
}
