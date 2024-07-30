package org.jsp.ems.controller;

import java.util.List;

import org.jsp.ems.entity.Employee;
import org.jsp.ems.responsestructure.ResponseStructure;
import org.jsp.ems.service.EmployeeService;
import org.jsp.ems.util.AuthEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeById() {
		return service.findAllEmployee();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmailAndPassword(@RequestBody AuthEmployee authEmployee) {
		return service.findEmployeeByEmailAndPassword(authEmployee.getEmail(), authEmployee.getPassword());
	}

}
