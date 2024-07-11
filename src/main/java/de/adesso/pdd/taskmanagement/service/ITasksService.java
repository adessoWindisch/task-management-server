package de.adesso.pdd.taskmanagement.service;

import de.adesso.pdd.taskmanagement.dto.TaskDto;
import de.adesso.pdd.taskmanagement.dto.TaskStatusDto;
import de.adesso.pdd.taskmanagement.entity.TaskStatus;

import java.util.List;

/**
 * Interface for the Task Service.
 * Defines the operations that can be performed on tasks within the system.
 */
public interface ITasksService {

    /**
     * Adds a new task to the system.
     *
     * @param taskDto The task data transfer object containing task details.
     * @return The added task as a data transfer object.
     */
    TaskDto addTask(TaskDto taskDto);

    /**
     * Updates an existing task in the system.
     *
     * @param taskDto The task data transfer object with updated details.
     * @return true if the task was successfully updated, false otherwise.
     */
    boolean updateTask(TaskDto taskDto);

    /**
     * Deletes a task from the system using the task's id.
     *
     * @param id The id of the task to be deleted.
     * @return true if the task was successfully deleted, false otherwise.
     */
    boolean deleteTaskById(long id);

    /**
     * Retrieves all tasks in the system.
     *
     * @return A list of all tasks as data transfer objects.
     */
    List<TaskDto> getAllTasks();

    /**
     * Retrieves tasks assigned to a specific employee.
     *
     * @param employeeId The id of the employee whose tasks are to be retrieved.
     * @return A list of tasks assigned to the employee.
     */
    List<TaskDto> getTasksByEmployeeId(long employeeId);

    /**
     * Retrieves a task by its id.
     *
     * @param id The id of the task to be retrieved.
     * @return The task with the given id as a data transfer object.
     */
    TaskDto getTaskById(long id);

    /**
     * Updates the status of an existing task.
     *
     * @param taskDto The task data transfer object with updated status.
     * @return true if the task status was successfully updated, false otherwise.
     */
    boolean updateTaskStatus(long taskId, TaskStatusDto status);
}
