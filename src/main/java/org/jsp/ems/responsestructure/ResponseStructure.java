package org.jsp.ems.responsestructure;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int httpCode;
	private String message;
	private T body;
}
