package com.resoTech.TaskManagement.Repository;

import com.resoTech.TaskManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User , Long> {
    User findFirstByUserEmail(String newEmail);
}
