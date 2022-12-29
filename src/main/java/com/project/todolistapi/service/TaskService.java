package com.project.todolistapi.service;

import com.project.todolistapi.model.Task;
import com.project.todolistapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task save(Task task){
        repository.save(task);
        return task;
    }

    public List<Task> getAll(){
        List<Task> taskList = repository.findAll();
        return taskList;
    }

    public Optional<Task> getById(Long id){
        return repository.findById(id);
    }

    public Task update(Task task){
        repository.save(task);
        return task;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
