package de.adesso.pdd.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "A DTO that represents an error response.")
public class ErrorResponseDto {
    @Schema(description = "The API path that resulted in the error.", example = "/api/tasks/1")
    private String apiPath;

    @Schema(description = "The HTTP status code of the error.", example = "404")
    private HttpStatus errorCode;

    @Schema(description = "A message describing the error.", example = "Task not found.")
    private String errorMessage;

    @Schema(description = "The time when the error occurred.", example = "2023-04-05T10:15:30")
    private LocalDateTime errorTime;
}