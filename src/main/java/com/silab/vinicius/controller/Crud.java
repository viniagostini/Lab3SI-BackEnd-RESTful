package com.silab.vinicius.controller;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * Created by viniagostini on 31/01/2017.
 */

public interface Crud<T> {

    ResponseEntity<T> create(T t);

    ResponseEntity<Collection<T>> getAll();

    ResponseEntity<T> getById(long id);

    ResponseEntity<T> update(T t);

    ResponseEntity<T> removeById(long id);

    ResponseEntity<T> removeAll();

}
