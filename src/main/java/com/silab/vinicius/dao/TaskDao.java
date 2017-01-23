package com.silab.vinicius.dao;

import com.silab.vinicius.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by viniagostini on 23/01/2017.
 */
@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

}
