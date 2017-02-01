package com.silab.vinicius.Service;

import com.silab.vinicius.dao.TaskListDao;
import com.silab.vinicius.entity.TaskCategory;
import com.silab.vinicius.entity.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Service
public class TaskListService {

    @Autowired
    private TaskListDao taskListDao;

    public void createTaskList(TaskList taskList){
        taskListDao.save(taskList);
    }

    public Collection<TaskList> getAllTaskLists(){
        return  taskListDao.findAll();
    }

    public TaskList getTaskListById(long id){
        return taskListDao.findOne(id);
    }

    public TaskList updateTaskList(TaskList taskList){
        taskListDao.save(taskList);
        return this.getTaskListById(taskList.getId());
    }

    public boolean removeTaskList(long id){
        boolean result = this.getTaskListById(id) != null;
        taskListDao.delete(id);
        return result;
    }

    public void removeAllTaskLists(){
        taskListDao.deleteAll();
    }

}
