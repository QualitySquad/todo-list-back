package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.exceptions.DataIntegrityException;
import com.example.todolist.service.exceptions.ObjectNotFoundException;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository repo;

    public Task find(Integer id){
        Optional<Task> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Task.class.getName()));
    }

    public List<Task> findAll() {
        return repo.findAll();
    }

    public Task insert(Task task){
        task.setId(null);
        return repo.save(task);
    }

    public Task update(Task task){
        find(task.getId());
        return repo.save(task);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }

    }

}
