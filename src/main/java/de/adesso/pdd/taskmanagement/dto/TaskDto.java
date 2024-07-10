package de.adesso.pdd.taskmanagement.dto;

import de.adesso.pdd.taskmanagement.entity.TaskPriority;
import de.adesso.pdd.taskmanagement.entity.TaskStatus;
import de.adesso.pdd.taskmanagement.entity.TaskType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class TaskDto {
    private Long taskId;

    @NotNull(message = "EmployeeId can not be a null!")
    private Long employeeId;

    private TaskType type;

    private TaskStatus status;

    private TaskPriority priority;

    @NotEmpty(message = "Description can not be a null or empty!")
    private String description;

    private String startDate;

    private String endDate;
}
