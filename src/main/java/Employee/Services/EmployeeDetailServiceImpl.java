package Employee.Services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Employee.Repository.EmployeeRepository;

@Service
public class EmployeeDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));
	}

}
