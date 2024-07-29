package org.jsp.ems.service.exceptionhandler;

import org.jsp.ems.responsestructure.ResponseStructure;
import org.jsp.ems.service.exceptionclasses.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlerEmployeeNotFoundException(EmployeeNotFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setHttpCode(HttpStatus.OK.value());
		structure.setMessage("Employee Not Found For The Given Detalis...");
		structure.setBody(e.getMessage());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
