package Employee.Exception;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	

}
