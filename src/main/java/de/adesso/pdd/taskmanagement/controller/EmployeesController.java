package de.adesso.pdd.taskmanagement.controller;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;
import de.adesso.pdd.taskmanagement.service.IEmployeesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeesController {

    private final IEmployeesService employeesService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeesService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeesService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeesService.addEmployee(employeeDto));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeesService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeesService.deleteEmployeeById(id));
    }
}