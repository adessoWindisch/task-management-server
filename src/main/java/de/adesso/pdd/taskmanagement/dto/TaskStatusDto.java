package de.adesso.pdd.taskmanagement.dto;

import de.adesso.pdd.taskmanagement.entity.TaskPriority;
import de.adesso.pdd.taskmanagement.entity.TaskStatus;
import de.adesso.pdd.taskmanagement.entity.TaskType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class TaskStatusDto {
    private TaskStatus status;
}
