package com.silab.vinicius.controller;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * Created by viniagostini on 31/01/2017.
 */

public interface Crud<T> {

    public ResponseEntity<T> create(T t);

    public ResponseEntity<Collection<T>> getAll();

    public ResponseEntity<T> getById(long id);

    public ResponseEntity<T> update(T t);

    public ResponseEntity<T> removeById(long id);

    public ResponseEntity<T> removeAll();

}
