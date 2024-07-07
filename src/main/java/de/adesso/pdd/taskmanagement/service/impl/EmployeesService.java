package de.adesso.pdd.taskmanagement.service.impl;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;
import de.adesso.pdd.taskmanagement.entity.Employee;
import de.adesso.pdd.taskmanagement.exception.EmployeeAlreadyExistsException;
import de.adesso.pdd.taskmanagement.exception.ResourceNotFoundException;
import de.adesso.pdd.taskmanagement.mapper.EmployeesMapper;
import de.adesso.pdd.taskmanagement.repository.EmployeesRepository;
import de.adesso.pdd.taskmanagement.service.IEmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeesService implements IEmployeesService {

    private EmployeesRepository employeesRepository;

    private static final String EMPLOYEE = "Employee";
    private static final String EMPLOYEEID = "EmployeeId";

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeesMapper.toEmployee(employeeDto);
        Optional<Employee> optionalEmployee = employeesRepository.findByOrgId(employeeDto.getOrgId());

        if(optionalEmployee.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already registered with given org id " + employee.getMobileNumber());
        }

        Employee savedEmployee = employeesRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeesMapper.toEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        boolean isUpdated = false;
        Optional<Employee> optionalEmployee = employeesRepository.findByEmployeeId(employeeDto.getEmployeeId());

        if(optionalEmployee.isEmpty()) {
            throw new ResourceNotFoundException(EMPLOYEE, EMPLOYEEID, String.valueOf(employeeDto.getEmployeeId()));
        }

        Employee givenEmployee = EmployeesMapper.toGivenEmployee(optionalEmployee.get(), employeeDto);
        Employee updatedEmployee = employeesRepository.save(givenEmployee);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean deleteEmployeeById(long id) {
        Employee employee = employeesRepository.findByEmployeeId(id).orElseThrow(
                () -> new ResourceNotFoundException(EMPLOYEE, EMPLOYEEID, String.valueOf(id)));

        employeesRepository.delete(employee);
        return true;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeesRepository.findAll();

        List<EmployeeDto> employeesDto = employees.stream()
                .map(employee -> EmployeesMapper.toEmployeeDto(employee))
                .collect(Collectors.toList());

        return employeesDto;
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeesRepository.findByEmployeeId(id).orElseThrow(
            () -> new ResourceNotFoundException(EMPLOYEE, EMPLOYEEID, String.valueOf(id)));

        EmployeeDto employeeDto = EmployeesMapper.toEmployeeDto(employee);
        return employeeDto;
    }
}
