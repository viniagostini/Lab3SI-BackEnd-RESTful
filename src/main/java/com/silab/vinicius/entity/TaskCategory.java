package com.silab.vinicius.entity;

import com.silab.vinicius.entity.task.Task;

import javax.persistence.*;
import java.util.List;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Entity
public class TaskCategory {

    @Id
    @Column(name = "TASK_CATEGORY_ID")
    @GeneratedValue
    private long id;
    private String name;
    private String color;


    @OneToMany(targetEntity = Task.class, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public TaskCategory(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public TaskCategory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
