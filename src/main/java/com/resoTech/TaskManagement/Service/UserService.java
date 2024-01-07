package com.resoTech.TaskManagement.Service;

import com.resoTech.TaskManagement.Model.AuthenticationToken;
import com.resoTech.TaskManagement.Model.DTO.SignInInput;
import com.resoTech.TaskManagement.Model.DTO.SignUpOutput;
import com.resoTech.TaskManagement.Model.Task;
import com.resoTech.TaskManagement.Model.User;
import com.resoTech.TaskManagement.Repository.IUserRepository;
import com.resoTech.TaskManagement.Service.Utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    IUserRepository userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    TaskService taskService;


    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(false,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(false,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //saveAppointment the user with the new encrypted password

            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(true, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(false,signUpStatusMessage);
        }
    }


    public String signInUser(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authenticationService.createToken(authToken);

                return "your token is = " + authToken.getTokenValue();
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }


    public String signOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        AuthenticationToken token = authenticationService.findFirstByUser(user);
        authenticationService.deleteToken(token);
        return "User Signed out successfully";
    }


    public Object getAllTasks() {
        return taskService.getAllTasks();
    }

    public Object getTaskById(Long id) {
        return taskService.getTaskById(id);
    }

    public Object createTask(Task task, String email) {
        User taskOwner = userRepo.findFirstByUserEmail(email);
        task.setTaskOwner(taskOwner);
        return taskService.createTask(task);
    }

    public String updateTask(Long id, Task updatedTask, String email) {
        User user = userRepo.findFirstByUserEmail(email);
        return taskService.updateTask(id , updatedTask , user);
    }

    public String deleteTask(Long id, String email) {
        User user = userRepo.findFirstByUserEmail(email);
        return taskService.deleteTask(id,user);
    }
}
