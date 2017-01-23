package com.silab.vinicius.entity;

import javax.persistence.*;

/**
 * Created by viniagostini on 22/01/2017.
 */
@Entity
public class SubTask {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

    public SubTask(long id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public SubTask() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }



    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }

}