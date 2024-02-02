package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("/")                // CREATE TASK
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @GetMapping("/")                 // GET ALL TASKS
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable String userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @GetMapping("/{id}")             // GET TASK BY TASKID
    public ResponseEntity<Task> getTaskById(@PathVariable String id) throws Throwable {
        Optional<Task> taskOptional = Optional.ofNullable(taskService.getTaskById(id));
        return taskOptional.map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")          // DELETE TASK BY TASKID
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
