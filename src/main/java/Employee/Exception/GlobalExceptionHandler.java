package Employee.Exception;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String nullpointer(NullPointerException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public String userNameNotFound(UsernameNotFoundException ex)
	{ 
		return ex.getMessage(); 
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String resourceNotFoundException(ResourceNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(EmployeeRoleException.class)
	public String employeeRoleException(EmployeeRoleException ex)
	{
		return ex.getMessage();
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String , String> handleInvalidArugment (MethodArgumentNotValidException ex)
	{
		Map<String , String> errorMap =new  HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});	
		System.out.println(errorMap);
		return errorMap;
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String duplicateValue(SQLIntegrityConstraintViolationException ex)
	{
		return "Duplicate Entry of  value!!!";
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public String httpMessageNotReadableException(HttpMessageNotReadableException ex )
	{
		return "Provide Valid Date Format yyyy-mm-dd";
	}
}


















