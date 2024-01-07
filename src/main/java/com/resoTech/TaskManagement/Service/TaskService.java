package com.resoTech.TaskManagement.Service;

import com.resoTech.TaskManagement.Model.Task;
import com.resoTech.TaskManagement.Model.User;
import com.resoTech.TaskManagement.Repository.ITaskRepository;
import com.resoTech.TaskManagement.Repository.IUserRepository;
import com.resoTech.TaskManagement.Service.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    ITaskRepository taskRepository;

    @Autowired
    IUserRepository userRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        task.setCreatedOrUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public String updateTask(Long id, Task updatedTask, User user) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task != null && task.getTaskOwner().equals(user)) {

            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDueDate(updatedTask.getDueDate());
            task.setStatus(updatedTask.getStatus());
            task.setCreatedOrUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
            return "Task Updated";
        }
        else {
            return "Task not found with id: " + id;
        }
    }

    public String deleteTask(Long id , User user) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null && task.getTaskOwner().equals(user))
        {
            taskRepository.deleteById(id);
            return "Task Deleted Successfully!!!";
        }
        else if (task == null)
        {
            return "Task to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }
}
