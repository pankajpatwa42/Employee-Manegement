package Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Employee.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmail(String email);
	
}
