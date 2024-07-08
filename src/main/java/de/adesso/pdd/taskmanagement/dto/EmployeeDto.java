package de.adesso.pdd.taskmanagement.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


@Data
public class EmployeeDto {
    private Long employeeId;

    @NotEmpty(message = "OrgID can not be a null or empty!")
    private String orgId;

    @NotEmpty(message = "First Name can not be a null or empty!")
    private String firstName;

    @NotEmpty(message = "Last Name can not be a null or empty!")
    private String lastName;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Email should be valid!")
    private String eMail;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
    private String mobileNumber;
}
