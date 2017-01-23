package com.silab.vinicius.Service;

import com.silab.vinicius.dao.TaskCategoryDao;
import com.silab.vinicius.entity.TaskCategory;
import com.silab.vinicius.entity.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Service
public class TaskCategoryService {

    @Autowired
    private TaskCategoryDao taskCategoryDao;


    public void createTaskCategory(TaskCategory taskCategory){
        taskCategoryDao.save(taskCategory);
    }

    public Collection<TaskCategory> getAllTaskCategories(){
        return  taskCategoryDao.findAll();
    }

    public TaskCategory getTaskCategoryById(long id){
        return taskCategoryDao.findOne(id);
    }

    public TaskCategory updateTaskCategory(TaskCategory taskCategory){
        taskCategoryDao.save(taskCategory);
        return this.getTaskCategoryById(taskCategory.getId());
    }

    public boolean removeTaskCategory(long id){
        boolean result = this.getTaskCategoryById(id) != null;
        taskCategoryDao.delete(id);
        return result;
    }


}
