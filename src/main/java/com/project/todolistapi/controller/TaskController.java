package com.project.todolistapi.controller;

import com.project.todolistapi.model.Task;
import com.project.todolistapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;

    @PostMapping
    public ResponseEntity saveTask(@RequestBody Task task){
        return new ResponseEntity(service.save(task), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllTask(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity getTaskById(@RequestParam Long id){
        return new ResponseEntity(service.getById(id), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateTask (@RequestBody Task task){
        return new ResponseEntity(service.update(task), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTask (@RequestParam Long id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
