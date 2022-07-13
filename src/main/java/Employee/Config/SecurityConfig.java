package Employee.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import Employee.Services.EmployeeDetailServiceImpl;


@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	private static final String [] url = 
		{"/org/**","/employee/all","/employee/delete/**","/employee/updaterole/**","/assets/saveassest"};
	
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	  @Autowired
	  EmployeeDetailServiceImpl employeeDetailsService;
	

	@Bean
	public PasswordEncoder passwordEncoder()
	{	
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(this.employeeDetailsService).passwordEncoder(passwordEncoder());
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeHttpRequests()
		.antMatchers("/employee/signup").permitAll()
		.antMatchers(url).hasAnyRole("ADMIN")
//		.antMatchers("/employee/all").hasAnyRole("ADMIN")
//		.antMatchers("/employee/delete/**").hasAnyRole("ADMIN")
//		.antMatchers("/employee/updaterole/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/assets/**").hasAnyRole("ADMIN","NORMAL")
//		.antMatchers("/assets/saveassest").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/assets/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/assets/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/employee/delete/**").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated().and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	
	
	
	
	
	

}
