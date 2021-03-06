package com.silab.vinicius.controller;

import com.silab.vinicius.Service.TaskService;
import com.silab.vinicius.entity.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by viniagostini on 23/01/2017.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tasks")
public class TaskController implements Crud<Task>{

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> create(@RequestBody Task task){
        taskService.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> update(@RequestBody Task task){
        Task response = taskService.updateTask(task);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Task>> getAll(){
        Collection<Task> response = taskService.getAllTasks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getById(@PathVariable("id") long id){
        Task response = taskService.getTaskById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Task> removeById(@PathVariable("id") long id){
        boolean response = taskService.removeTask(id);
        HttpStatus status = (response) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Task> removeAll(){
        taskService.removeAllTasks();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
