package de.adesso.pdd.taskmanagement.dto;

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

    @NotEmpty(message = "Type can not be a null or empty!")
    private String type;

    @NotEmpty(message = "Description can not be a null or empty!")
    private String description;

    @NotEmpty(message = "Status can not be a null or empty!")
    private String status;

    @NotEmpty(message = "Priority can not be a null or empty!")
    private String priority;

    @NotEmpty(message = "Start Date can not be a null or empty!")
    private LocalDateTime startDate;

    @NotEmpty(message = "End Date can not be a null or empty!")
    private LocalDateTime endDate;
}
