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
    private String createAt;

    @OneToMany(targetEntity = Task.class, mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> tasks;


}
