package com.example.todolist.resource;

import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> returnTaskAll(){
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping(path = ("/{id}"))
    public ResponseEntity<?> returnTask(@PathVariable Integer id){
        Task tasks = taskService.find(id);
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    public ResponseEntity<Void> saveTask(@RequestBody Task task){
        task.setFinalizado(false);
        task = taskService.insert(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = ("/{id}"))
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = ("/{id}"))
    public ResponseEntity<Void> updateTask(@RequestBody Task task, @PathVariable Integer id){
        task.setId(id);
        taskService.update(task);
        return ResponseEntity.noContent().build();
    }


}
