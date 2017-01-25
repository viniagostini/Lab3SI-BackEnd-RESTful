package com.silab.vinicius.controller;

import com.silab.vinicius.Service.TaskListService;
import com.silab.vinicius.Service.TaskService;
import com.silab.vinicius.entity.TaskList;
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
@RequestMapping(value = "/tasklists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskList> createTaskList(@RequestBody TaskList taskList){
        taskListService.createTaskList(taskList);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskList> updateTaskList(@RequestBody TaskList taskList){
        TaskList response = taskListService.updateTaskList(taskList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TaskList>> getAllTaskLists(){
        Collection<TaskList> response = taskListService.getAllTaskLists();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskList> getTaskListById(@PathVariable("id") long id){
        TaskList response = taskListService.getTaskListById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaskList> removeTaskList(@PathVariable("id") long id){
        boolean response = taskListService.removeTaskList(id);
        HttpStatus status = (response) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status);
    }


}
