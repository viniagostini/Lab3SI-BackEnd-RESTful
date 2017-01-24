package com.silab.vinicius.controller;

import com.silab.vinicius.Service.SubTaskService;
import com.silab.vinicius.entity.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by viniagostini on 22/01/2017.
 */
@RestController
@CrossOrigin()
@RequestMapping(value = "/subtasks")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTask> createSubTask(@RequestBody SubTask subTask){
        subTaskService.createSubTask(subTask);
        return new ResponseEntity<>(subTask, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTask> updateSubTask(@RequestBody SubTask subTask){
        SubTask response = subTaskService.updateSubTask(subTask);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<SubTask>> getAllSubTasks(){
        Collection<SubTask> response = subTaskService.getAllSubTasks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubTask> getSubTaskById(@PathVariable("id") long id){
        SubTask response = subTaskService.getSubTaskById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SubTask> removeSubTask(@PathVariable("id") long id){
        boolean response = subTaskService.removeSubTask(id);
        HttpStatus status = (response) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status);
    }





}
