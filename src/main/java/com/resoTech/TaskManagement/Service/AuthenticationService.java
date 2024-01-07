package com.resoTech.TaskManagement.Service;

import com.resoTech.TaskManagement.Model.AuthenticationToken;
import com.resoTech.TaskManagement.Model.User;
import com.resoTech.TaskManagement.Repository.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepository authenticationRepository;

    public void createToken(AuthenticationToken token) {
        authenticationRepository.save(token);
    }

    public boolean authenticate(String email,String tokenValue) {


        AuthenticationToken token =  authenticationRepository.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public void deleteToken(AuthenticationToken tokenValue) {
        authenticationRepository.delete(tokenValue);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepository.findFirstByUser(user);
    }
}
