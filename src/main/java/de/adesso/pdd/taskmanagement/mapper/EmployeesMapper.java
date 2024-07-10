package de.adesso.pdd.taskmanagement.mapper;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;
import de.adesso.pdd.taskmanagement.entity.Employee;

public class EmployeesMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setOrgId(employee.getOrgId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEMail(employee.getEMail());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        return employeeDto;
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        return toGivenEmployee(employee, employeeDto);
    }

    public static Employee toGivenEmployee(Employee givenEmployee, EmployeeDto employeeDto) {
        givenEmployee.setEmployeeId(employeeDto.getEmployeeId());
        givenEmployee.setOrgId(employeeDto.getOrgId());
        givenEmployee.setFirstName(employeeDto.getFirstName());
        givenEmployee.setLastName(employeeDto.getLastName());
        givenEmployee.setEMail(employeeDto.getEMail());
        givenEmployee.setMobileNumber(employeeDto.getMobileNumber());
        return givenEmployee;
    }
}
