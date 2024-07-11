package de.adesso.pdd.taskmanagement.dto;

import de.adesso.pdd.taskmanagement.entity.TaskPriority;
import de.adesso.pdd.taskmanagement.entity.TaskStatus;
import de.adesso.pdd.taskmanagement.entity.TaskType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Represents a task with all its details.")
public class TaskDto {
    @Schema(description = "The unique identifier of the task.", example = "1", required = true)
    private Long taskId;

    @Schema(description = "The unique identifier of the employee assigned to the task.", example = "100", required = true)
    @NotNull(message = "EmployeeId can not be a null!")
    private Long employeeId;

    @Schema(description = "The type of the task.", example = "BUG_FIX")
    private TaskType type;

    @Schema(description = "The current status of the task.", example = "IN_PROGRESS")
    private TaskStatus status;

    @Schema(description = "The priority of the task.", example = "HIGH")
    private TaskPriority priority;

    @Schema(description = "A brief description of the task.", example = "Fix the login bug.")
    @NotEmpty(message = "Description can not be a null or empty!")
    private String description;

    @Schema(description = "The start date of the task.", example = "2023-04-01")
    private String startDate;

    @Schema(description = "The end date of the task.", example = "2023-04-15")
    private String endDate;
}