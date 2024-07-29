package org.jsp.ems.repository;

import java.util.Optional;

import org.jsp.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByEmailAndPassword(String email, String password);
}
