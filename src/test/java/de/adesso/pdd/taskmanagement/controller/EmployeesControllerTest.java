package de.adesso.pdd.taskmanagement.controller;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;
import de.adesso.pdd.taskmanagement.dto.ErrorResponseDto;
import de.adesso.pdd.taskmanagement.entity.Employee;
import de.adesso.pdd.taskmanagement.exception.GlobalExceptionHandler;
import de.adesso.pdd.taskmanagement.exception.ResourceNotFoundException;
import de.adesso.pdd.taskmanagement.service.IEmployeesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeesControllerTest {

    @Mock
    private IEmployeesService employeesService;

    @InjectMocks
    private EmployeesController employeesController;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        // Arrange
        List<EmployeeDto> employees = Arrays.asList(
                new EmployeeDto(1L, "A123", "John", "Doe", "john.doe@example.com", "1234567890"),
                new EmployeeDto(2L, "B456", "Jane", "Smith", "jane.smith@example.com", "0987654321"));
        when(employeesService.getAllEmployees()).thenReturn(employees);

        // Act
        ResponseEntity<List<EmployeeDto>> response = employeesController.getAllEmployees();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
        verify(employeesService, times(1)).getAllEmployees();
    }

    // Add more test methods for other controller methods
    @Test
    void testGetEmployeeById() {
        // Arrange
        EmployeeDto employee = new EmployeeDto(1L, "A123", "John", "Doe", "", "");
        when(employeesService.getEmployeeById(1L)).thenReturn(employee);

        // Act
        ResponseEntity<EmployeeDto> response = employeesController.getEmployeeById(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
        verify(employeesService, times(1)).getEmployeeById(1L);
    }
}