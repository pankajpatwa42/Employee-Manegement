package Employee.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Employee.Exception.EmployeeRoleException;
import Employee.Exception.ResourceNotFoundException;
import Employee.Models.Employee;
import Employee.Models.Organization;
import Employee.Models.Role;
import Employee.Repository.EmployeeRepository;
import Employee.Repository.OrganizationRepository;
import Employee.Repository.RoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> employ1 = employeeRepository.findAll();
		if(employ1.isEmpty())
		{
			Organization getOrg = organizationRepository.findById(1).orElseThrow(null);
			employee.setOrganization(getOrg);
			Role role = roleRepository.findById(2).orElseThrow(null);
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			employee.setRole(roles);
			return employeeRepository.save(employee);
			
		}else {
		Organization getOrg = organizationRepository.findById(1).orElseThrow(null);
		employee.setOrganization(getOrg);
		Role role = roleRepository.findById(1).orElseThrow(null);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		employee.setRole(roles);
		return employeeRepository.save(employee);
		}
	}

	
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setWorkDept(employee.getWorkDept());

		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "ID", id));
		employeeRepository.delete(employee);
		
	}



	@Override
	public void AdminsetRole(int id,Role role) {
		// TODO Auto-generated method stub
		Employee asr = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
		
		if(role.getRoleName().equals("ROLE_ADMIN"))
		{
			Role r1 = new Role ();
			r1.setRoleId(2);
			r1.setRoleName("ROLE_ADMIN");
			Set<Role> Role = new HashSet<>();
			Role.add(r1);
			asr.setRole(Role);
			employeeRepository.save(asr);
		}else if (role.getRoleName().equals("ROLE_NORMAL"))
		{
			Role r1 = new Role ();
			r1.setRoleId(1);
			r1.setRoleName("ROLE_NORMAL");
			Set<Role> Role = new HashSet<>();
			Role.add(r1);
			asr.setRole(Role);
			employeeRepository.save(asr);
		}else {
			System.out.println("Employee Id invalid");
			throw new EmployeeRoleException("Employee Id invalid which you logged in!!!!");

		}
	}
}










