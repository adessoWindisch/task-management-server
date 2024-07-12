package de.adesso.pdd.taskmanagement.controller;

import de.adesso.pdd.taskmanagement.dto.TaskDto;
import de.adesso.pdd.taskmanagement.dto.TaskStatusDto;
import de.adesso.pdd.taskmanagement.service.ITasksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Tasks", description = "Tasks API")
public class TasksController {

    private final ITasksService tasksService;

    @Operation(summary = "Get all tasks", description = "Get all tasks", tags = { "Tasks" }, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    @Operation(summary = "Get task by id", description = "Get task by id", tags = { "Tasks" }, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Task not found")
    })
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok(tasksService.getTaskById(taskId));
    }

    @Operation(summary = "Get tasks by employee id", description = "Get tasks by employee id", tags = {
            "Tasks" }, responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
            })
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TaskDto>> getTasksByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(tasksService.getTasksByEmployeeId(employeeId));
    }

    @Operation(summary = "Create a new task", description = "Create a new task", tags = { "Tasks" }, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto TaskDto) {
        return ResponseEntity.ok(tasksService.addTask(TaskDto));
    }

    @Operation(summary = "Update a task", description = "Update a task", tags = { "Tasks" }, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @PutMapping
    public ResponseEntity<Boolean> updateTask(@Valid @RequestBody TaskDto TaskDto) {
        return ResponseEntity.ok(tasksService.updateTask(TaskDto));
    }

    @Operation(summary = "Delete a task by id", description = "Delete a task by id", tags = { "Tasks" }, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(tasksService.deleteTaskById(id));
    }
/*    @PatchMapping("/{taskId}/status")
    public ResponseEntity<Boolean> updateTaskStatus(@PathVariable Long taskId, @Valid @RequestBody TaskStatusDto taskStatusDto) {
        return ResponseEntity.ok(tasksService.updateTaskStatus(taskId, taskStatusDto));
    }*/

}