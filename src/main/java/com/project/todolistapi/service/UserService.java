package com.project.todolistapi.service;

import com.project.todolistapi.model.Task;
import com.project.todolistapi.model.User;
import com.project.todolistapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User save(User user){
        repository.save(user);
        return user;
    }

    public List<User> getAll(){
        List<User> userList = repository.findAll();
        return userList;
    }

    public Optional<User> getById(Long id){
        return repository.findById(id);
    }

    public User update(User user){
        repository.save(user);
        return user;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
