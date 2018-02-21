package cmc.formacion.springbootrest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ApiRestExceptionHandler.class);
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> manejadorNotFoundException(NotFoundException e){
		
		log.error(e.getMessage(), e);
		
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), 
				"The server cannot or will not process the request", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
