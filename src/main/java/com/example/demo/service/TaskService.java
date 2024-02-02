package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {    // CREATE TASK
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {      // GET ALL TASKS
        return taskRepository.findAll();
    }

    public Task getTaskById(String id) throws Throwable {  // GET TASK BY TASKID
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
    public List<Task> getTasksByUserId(String userId) {     // GET ALL TASKS BY USERID
        return taskRepository.findByUserId(userId);
    }
    public void deleteTask(String id) {      // DELETE TASK BY TAKSID
        if(taskRepository.existsById(id))
            taskRepository.deleteById(id);
    }
}
