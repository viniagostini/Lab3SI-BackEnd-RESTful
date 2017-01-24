package com.silab.vinicius.entity.task;

import com.silab.vinicius.entity.SubTask;
import com.silab.vinicius.entity.TaskCategory;
import com.silab.vinicius.entity.TaskList;

import javax.persistence.*;
import java.util.List;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Entity
public class Task {

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String title;
    private TaskPriority priority;
    @ManyToOne
    @JoinColumn(name = "TASK_CATEGORY_ID")
    private TaskCategory category;
    private String description;
    private String createdAt;
    private String doneAt;
    @ManyToOne
    @JoinColumn(name = "TASK_LIST_ID")
    private TaskList taskList;


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<SubTask> subTasks;

    public Task(String title, TaskPriority priority, TaskCategory category, String description, String createdAt, String doneAt) {
        this.title = title;
        this.priority = priority;
        this.category = category;
        this.description = description;
        this.createdAt = createdAt;
        this.doneAt = doneAt;
    }

    public Task() {
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

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskCategory getCategory() {
        return category;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(String doneAt) {
        this.doneAt = doneAt;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
}
