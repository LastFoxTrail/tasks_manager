package com.lis.projects.model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class Task {
    @Id
    private int id;

    @NotBlank(message = "Task name should not be empty")
    private String title;

    private String text;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Dead line must match the pattern yyyy-mm-dd")
    private String deadLine;

    private Date dateOfChange;

    public Task() {
        Date date = new Date();
        this.dateOfChange = date;
    }

    public Task(int id, String title, String text, String deadLine) {
        Date date = new Date();
        this.id = id;
        this.title = title;
        this.text = text;
        this.deadLine = deadLine;
        this.dateOfChange = date;
    }

    @PersistenceConstructor
    public Task(String title, String text, String deadLine, Date dateOfChange) {
        Date date = new Date();
        this.title = title;
        this.text = text;
        this.deadLine = deadLine;
        this.dateOfChange = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(java.util.Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", deadLine=" + deadLine +
                ", dateOfChange=" + dateOfChange +
                '}';
    }
}
