package com.resoTech.TaskManagement.Repository;

import com.resoTech.TaskManagement.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task , Long> {
}
