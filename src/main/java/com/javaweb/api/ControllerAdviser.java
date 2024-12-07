package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorCustom;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request){
		ErrorCustom errorCustom = new ErrorCustom();
		errorCustom.setName(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("số nguyên làm sao chia hết cho 0 ?");
		errorCustom.setDetail(details);
		return new ResponseEntity<Object>(errorCustom, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldException(FieldRequiredException ex, WebRequest request){
		ErrorCustom errorCustom = new ErrorCustom();
		errorCustom.setName(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("ko dc null");
		errorCustom.setDetail(details);
		return new ResponseEntity<Object>(errorCustom, HttpStatus.BAD_GATEWAY);
	} 


}
