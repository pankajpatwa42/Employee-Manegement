package Employee.Services;

import java.util.List;

import Employee.Models.Employee;
import Employee.Models.Role;


public interface EmployeeService {
	
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	Employee updateEmployee(Employee employee,int id);
	
	void deleteEmployee(int id);
	
	void AdminsetRole(int id,Role role);

}
