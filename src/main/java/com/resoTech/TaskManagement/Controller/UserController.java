package com.resoTech.TaskManagement.Controller;

import com.resoTech.TaskManagement.Model.DTO.SignInInput;
import com.resoTech.TaskManagement.Model.DTO.SignUpOutput;
import com.resoTech.TaskManagement.Model.Task;
import com.resoTech.TaskManagement.Model.User;
import com.resoTech.TaskManagement.Service.AuthenticationService;
import com.resoTech.TaskManagement.Service.TaskService;
import com.resoTech.TaskManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody @Valid User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String signOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.signOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @GetMapping("/tasks")
    public Object getAllTasks(@RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.getAllTasks();
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("/tasks/{id}")
    public Object getTaskById(@PathVariable Long id, @RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.getTaskById(id);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }

    @PostMapping("/tasks")
    public Object createTask(@Valid @RequestBody Task task , @RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.createTask(task , email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @Valid @RequestBody Task updatedTask ,@RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.updateTask(id , updatedTask,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }

    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id , @RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.deleteTask(id,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
}
