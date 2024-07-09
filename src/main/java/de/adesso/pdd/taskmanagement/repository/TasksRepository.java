package de.adesso.pdd.taskmanagement.repository;

import de.adesso.pdd.taskmanagement.entity.Employee;
import de.adesso.pdd.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTaskId(Long TaskId);

    List<Task> findByEmployeeId(Long EmployeeId);
}
