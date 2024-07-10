package de.adesso.pdd.taskmanagement.service;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;

import java.util.List;

/**
 * This interface defines the contract for the Employee Service.
 * It provides methods for managing employees in the system.
 */
public interface IEmployeesService {

    /**
     * Adds a new employee to the system.
     *
     * @param employeeDto The employee data transfer object to be added.
     * @return The added employee as a data transfer object.
     */
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    /**
     * Updates an existing employee in the system.
     *
     * @param employeeDto The employee data transfer object with updated details.
     * @return The updated employee as a data transfer object.
     */
    boolean updateEmployee(EmployeeDto employeeDto);

    /**
     * Deletes an employee from the system using the employee's id.
     *
     * @param id The id of the employee to be deleted.
     * @return true if the employee was successfully deleted, false otherwise.
     */
    boolean deleteEmployeeById(long id);

    /**
     * Retrieves all employees in the system.
     *
     * @return A list of all employees.
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * Retrieves an employee by their id.
     *
     * @param id The id of the employee to be retrieved.
     * @return The employee with the given id.
     */
    EmployeeDto getEmployeeById(long id);
}