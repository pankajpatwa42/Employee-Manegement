package Employee.Models;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empno;
	
	@NotEmpty(message = "Firstname not be empty")
	private String firstName;
	
	@NotEmpty(message = "Lastname not be empty")
	private String lastName;
	
	@NotEmpty(message = "Work Deptartment not be empty")
	private String workDept;
	
//	@Positive(message = "Salary must be in POSITIVE")
	@Range(min = 5000,message = "Minimum Salary must be 5000")
	private int salary;
	
	@Email(message = "give proper Email format ")
	@Column(unique=true )
	private String email;
	
	@NotEmpty(message = "Password not be Empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",message = "Password contain atleast 1 digit and one lowercase[a-z] and uppercase[A-Z] and minimum 8 character")
	private String password;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Role> Role = new HashSet<>();
	
	
	@ManyToOne
	@JsonBackReference
	private Organization organization;
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWorkDept() {
		return workDept;
	}
	public void setWorkDept(String workDept) {
		this.workDept = workDept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRole() {
		return Role;
	}
	public void setRole(Set<Role> role) {
		Role = role;
	}
	
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority>authorities=this.Role.stream()
				.map((role)-> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());		
	return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
}
