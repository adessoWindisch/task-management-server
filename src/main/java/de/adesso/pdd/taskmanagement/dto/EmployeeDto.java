package de.adesso.pdd.taskmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee Data Transfer Object")
public class EmployeeDto {
    @Schema(description = "Employee ID", example = "1", required = true)
    private Long employeeId;

    @NotEmpty(message = "OrgID can not be a null or empty!")
    @Schema(description = "Organization ID", example = "A123", required = true)
    private String orgId;

    @NotEmpty(message = "First Name can not be a null or empty!")
    @Schema(description = "Employee's first name", example = "John", required = true)
    private String firstName;

    @NotEmpty(message = "Last Name can not be a null or empty!")
    @Schema(description = "Employee's last name", example = "Doe", required = true)
    private String lastName;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Email should be valid!")
    @Schema(description = "Employee's email address", example = "john.doe@example.com", required = true)
    private String eMail;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
    @Schema(description = "Employee's mobile number", example = "1234567890", required = false)
    private String mobileNumber;
}