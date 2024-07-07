package de.adesso.pdd.taskmanagement.repository;

import de.adesso.pdd.taskmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(Long employeeId);

    Optional<Employee> findByOrgId(String orgId);
}
