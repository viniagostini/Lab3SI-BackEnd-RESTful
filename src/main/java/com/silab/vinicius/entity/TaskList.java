package com.silab.vinicius.entity;

import com.silab.vinicius.entity.task.Task;

import javax.persistence.*;
import java.util.List;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Entity
public class TaskList {

    @Id
    @Column(name = "TASK_LIST_ID")
    @GeneratedValue
    private long id;
    private String title;
    private String createdAt;

    @OneToMany(targetEntity = Task.class, mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> tasks;


    public TaskList(String title, String createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }

    public TaskList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
