	package Employee.Controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Employee.Models.Employee;
import Employee.Models.Role;
import Employee.Services.EmployeeServiceImpl;


@RestController
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	public boolean checkAdmin()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee principal1 = (Employee) principal;
		Set<Role> roles = principal1.getRole();
		for(Role r : roles)
		{
			if(r.getRoleName().equals("ROLE_ADMIN"))
				return true;
		}
		return false;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Employee> saveEmployee( @Valid @RequestBody  Employee employee)
	{

		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){return employeeService.getAllEmployee();}
	
	@GetMapping("/employeeid/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee principal1 = (Employee) principal;
		if(principal1.getEmpno()==id)
		{
			return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);	
		}
		else if (checkAdmin())
		{
			return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("You are not Authorized",HttpStatus.BAD_REQUEST);	
		}
			
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") int id,@Valid @RequestBody Employee employee)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Employee principal1 = (Employee) principal;
		if(principal1.getEmpno()==id)
		{
			return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.OK);		
		}else if (checkAdmin())
				{
			return new ResponseEntity<>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
				}
		
		else {
			
			return new ResponseEntity<>("You are not Authorized",HttpStatus.BAD_REQUEST);	
		}
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return  "Successfully Deleted";
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/updaterole/{id}")
	public ResponseEntity<?> adminSetRole(@PathVariable("id") Integer id , @RequestBody Role role)
	{
		employeeService.AdminsetRole(id, role);
		return new ResponseEntity<>("Role is updated Successfully ",HttpStatus.OK);
	}
}
	
	












