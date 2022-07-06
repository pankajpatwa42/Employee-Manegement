package Employee.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Employee.Models.Organization;
import Employee.Services.OrganizationServiceImpl;


@RestController
@RequestMapping("/org")
public class OrganizationController {
	
	@Autowired
	private OrganizationServiceImpl organizationService;
	

	
	@PostMapping("/save")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Organization> saveOrganization(@Valid @RequestBody  Organization organization)
	{

		return new ResponseEntity<Organization>(organizationService.saveOrganization(organization),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Organization> getAllUser(){return organizationService.getAllOrganization();}
	
	@GetMapping("{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Organization>(organizationService.getOrganizationById(id),HttpStatus.OK);		
	}
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") int id,@Valid @RequestBody Organization organization)
	{
		return new ResponseEntity<Organization>(organizationService.updateOrganization(organization,id),HttpStatus.OK);		
	}
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteOrganization (@PathVariable("id") int id) {
		organizationService.deleteOrganization(id);
		return  "Successfully Deleted";
	}
}


