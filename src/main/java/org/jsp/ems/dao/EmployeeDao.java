package org.jsp.ems.dao;

import java.util.Optional;

import org.jsp.ems.entity.Employee;
import org.jsp.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Optional<Employee> findEmployeeById(int id) {
		return repository.findById(id);
	}

	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}

	public Optional<Employee> findByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

}
