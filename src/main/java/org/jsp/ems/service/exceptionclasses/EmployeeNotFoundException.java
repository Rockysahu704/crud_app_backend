package org.jsp.ems.service.exceptionclasses;

public class EmployeeNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Employee Not Found for the Id Given";
	}
	
}
