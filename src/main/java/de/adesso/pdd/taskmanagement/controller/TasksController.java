package de.adesso.pdd.taskmanagement.controller;

import de.adesso.pdd.taskmanagement.dto.TaskDto;
import de.adesso.pdd.taskmanagement.service.ITasksService;
import de.adesso.pdd.taskmanagement.service.ITasksService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TasksController {

    private final ITasksService tasksService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok(tasksService.getTaskById(taskId));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TaskDto>> getTasksByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(tasksService.getTasksByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto TaskDto) {
        return ResponseEntity.ok(tasksService.addTask(TaskDto));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateTask(@Valid @RequestBody TaskDto TaskDto) {
        return ResponseEntity.ok(tasksService.updateTask(TaskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(tasksService.deleteTaskById(id));
    }
}