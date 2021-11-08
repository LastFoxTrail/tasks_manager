package com.lis.projects.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lis.projects.service.TaskServiceImpl;
import org.springframework.ui.Model;
import com.lis.projects.model.Task;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private TaskServiceImpl taskService;

    @Autowired
    public TasksController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String getAll(Model model) {

        try {
            List<Task> tasks = taskService.get();
            model.addAttribute("tasks", tasks);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "tasks-list";
    }

    @RequestMapping("/new")
    public String newTask(Model model) {
        Task task = new Task();
        model.addAttribute("newTask", task);

        return "new-task";
    }

    @RequestMapping("/edit")
    public String editTask(@RequestParam("id") int id, Model model) {

        try {
            model.addAttribute("newTask", taskService.getById(id));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "new-task";
    }

    @RequestMapping("/save")
    public String create(@ModelAttribute("newTask") @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "new-task";

        } else {
            try {
                if (task.getId() == 0) {
                    taskService.add(task);

                } else {
                    taskService.update(task);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return "redirect:/tasks/";
        }
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {

        try {
            taskService.delete(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/tasks/";
    }
}
