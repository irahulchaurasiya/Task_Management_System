package com.resoTech.TaskManagement.Repository;

import com.resoTech.TaskManagement.Model.AuthenticationToken;
import com.resoTech.TaskManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);

    AuthenticationToken findFirstByUser(User user);
}
