package com.silab.vinicius.controller;

import com.silab.vinicius.Service.TaskCategoryService;
import com.silab.vinicius.Service.TaskService;
import com.silab.vinicius.entity.TaskCategory;
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
@RequestMapping(value = "/taskcategories")
public class TaskCategoryController implements Crud<TaskCategory>{
    @Autowired
    private TaskCategoryService taskCategoryService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskCategory> create(@RequestBody TaskCategory taskCategory){
        taskCategoryService.createTaskCategory(taskCategory);
        return new ResponseEntity<>(taskCategory, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskCategory> update(@RequestBody TaskCategory taskCategory){
        TaskCategory response = taskCategoryService.updateTaskCategory(taskCategory);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<TaskCategory>> getAll(){
        Collection<TaskCategory> response = taskCategoryService.getAllTaskCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskCategory> getById(@PathVariable("id") long id){
        TaskCategory response = taskCategoryService.getTaskCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaskCategory> removeById(@PathVariable("id") long id){
        boolean response = taskCategoryService.removeTaskCategory(id);
        HttpStatus status = (response) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(status);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<TaskCategory> removeAll(){
        taskCategoryService.removeAllTaskCategories();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
