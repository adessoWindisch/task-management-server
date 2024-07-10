package de.adesso.pdd.taskmanagement.mapper;

import de.adesso.pdd.taskmanagement.dto.TaskDto;
import de.adesso.pdd.taskmanagement.entity.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TasksMapper {
    public static TaskDto toTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setEmployeeId(task.getEmployeeId());
        taskDto.setType(task.getType());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());
        taskDto.setDescription(task.getDescription());
        taskDto.setStartDate(task.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        taskDto.setEndDate(task.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return taskDto;
    }

    public static Task toTask(TaskDto taskDto) {
        Task task = new Task();
        return toGivenTask(task, taskDto);
    }

    public static Task toGivenTask(Task givenTask, TaskDto taskDto) {
        givenTask.setTaskId(taskDto.getTaskId());
        givenTask.setEmployeeId(taskDto.getEmployeeId());
        givenTask.setType(taskDto.getType());
        givenTask.setStatus(taskDto.getStatus());
        givenTask.setPriority(taskDto.getPriority());
        givenTask.setDescription(taskDto.getDescription());
        givenTask.setStartDate(LocalDate.parse(taskDto.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        givenTask.setEndDate(LocalDate.parse(taskDto.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return givenTask;
    }
}
