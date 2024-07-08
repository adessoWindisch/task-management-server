package de.adesso.pdd.taskmanagement.service;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;

import java.util.List;

public interface ITasksService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);
    boolean updateEmployee(EmployeeDto employeeDto);
    boolean deleteEmployeeById(long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(long id);
}