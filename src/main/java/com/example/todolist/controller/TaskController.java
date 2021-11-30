package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> returnTask(){
        List<Task> tasks = taskService.buscarTudo();
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveTask(@RequestBody Task task){
        task.setFinalizado(false);
        taskService.adiciona(task);
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping(path = ("/{id}"))
    public ResponseEntity<?> deleteTask(@PathVariable Integer id){
        taskService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Task task){
        taskService.atualiza(task);
        return ResponseEntity.ok().body(task);
    }


}
