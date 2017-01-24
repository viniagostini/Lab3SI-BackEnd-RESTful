package com.silab.vinicius.dao;

import com.silab.vinicius.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Repository
public interface TaskListDao extends JpaRepository<TaskList, Long> {

}
