package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository repo;

    public Task buscar(Integer id){
        Optional<Task> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Task.class.getName()));
    }

    public List<Task> buscarTudo(){
        List<Task> obj = repo.findAll();
        return obj;
    }

    public Task adiciona(Task task){
        repo.save(task);
        return task;
    }

    public Task atualiza(Task task){
        repo.save(task);
        return task;
    }

    public void deletar(Integer id){
        repo.deleteById(id);
    }
}
