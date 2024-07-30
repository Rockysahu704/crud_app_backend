package org.jsp.ems.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ems.dao.EmployeeDao;
import org.jsp.ems.entity.Employee;
import org.jsp.ems.responsestructure.ResponseStructure;
import org.jsp.ems.service.exceptionclasses.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		
		System.out.println(employee);
		
		
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.CREATED.value());
		structure.setMessage("Employee Created...");
		structure.setBody(dao.saveEmployee(employee));
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.CREATED.value());
		structure.setMessage("Employee Updated...");
		structure.setBody(dao.saveEmployee(employee));
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		if (optional.isEmpty())
			throw new EmployeeNotFoundException();
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.OK.value());
		structure.setMessage("Employee Updated...");
		structure.setBody(optional.get());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		if (optional.isEmpty())
			throw new EmployeeNotFoundException();
		dao.deleteEmployeeById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.OK.value());
		structure.setMessage("Employee Deleted...");
		structure.setBody("Employee Deleted Successfully...");
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmailAndPassword(String email, String password) {
		Optional<Employee> optional = dao.findByEmailAndPassword(email, password);
		if (optional.isEmpty())
			throw new EmployeeNotFoundException();
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.OK.value());
		structure.setMessage("Employee Verified...");
		structure.setBody(optional.get());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		
		
		List<Employee> employees = dao.findAllEmployee();
		if(employees.isEmpty())
			throw new EmployeeNotFoundException();
		
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.OK.value());
		structure.setMessage("Employee Verified...");
		structure.setBody(employees);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
