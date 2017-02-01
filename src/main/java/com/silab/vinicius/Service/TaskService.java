package com.silab.vinicius.Service;

import com.silab.vinicius.dao.TaskDao;
import com.silab.vinicius.entity.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;


    public void createTask(Task task){
        taskDao.save(task);
    }

    public Collection<Task> getAllTasks(){
        return  taskDao.findAll();
    }

    public Task getTaskById(long id){
        return taskDao.findOne(id);
    }

    public Task updateTask(Task task){
        taskDao.save(task);
        return this.getTaskById(task.getId());
    }

    public boolean removeTask(long id){
        boolean result = this.getTaskById(id) != null;
        taskDao.delete(id);
        return result;
    }

    public void removeAllTasks() {
        taskDao.deleteAll();
    }
}
