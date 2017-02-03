package com.silab.vinicius.Service;

import com.silab.vinicius.dao.SubTaskDao;
import com.silab.vinicius.entity.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Service
public class SubTaskService {

    @Autowired
    SubTaskDao subTaskDao;

    public void createSubTask(SubTask subTask){
        subTaskDao.save(subTask);
    }

    public SubTask updateSubTask(SubTask subTask){
        subTaskDao.save(subTask);
        return this.getSubTaskById(subTask.getId());
    }

    public Collection<SubTask> getAllSubTasks(){
        return subTaskDao.findAll();
    }

    public SubTask getSubTaskById(long id){
        return subTaskDao.findOne(id);
    }

    public boolean removeSubTask(long id){
        boolean result = this.getSubTaskById(id) != null;
        subTaskDao.delete(id);
        return result;
    }

    public void removeAllSubTasks() {
        subTaskDao.deleteAll();
    }


}
