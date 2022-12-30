package com.project.todolistapi.controller;

import com.project.todolistapi.model.User;
import com.project.todolistapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user){
        return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUser(){
        List<User> userList = service.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity getUserById(Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity updateUser(@RequestBody User user){
        return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
