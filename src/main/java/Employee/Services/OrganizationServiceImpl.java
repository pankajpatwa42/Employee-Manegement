package Employee.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.Exception.ResourceNotFoundException;
import Employee.Models.Employee;
import Employee.Models.Organization;
import Employee.Repository.EmployeeRepository;
import Employee.Repository.OrganizationRepository;


@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Organization saveOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	public List<Organization> getAllOrganization() {
		return organizationRepository.findAll();
	}

	public Organization getOrganizationById(int id) {
		
		return organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization","ID",id));
	}
	

	public Organization updateOrganization(Organization organization, int id) {
		// TODO Auto-generated method stub
		Organization organization2 = organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization","ID",id));
		organization2.setName(organization.getName());
		organization2.setManager(organization.getManager());
		organization2.setEstablished(organization.getEstablished());
		organizationRepository.save(organization2);
		return organization2;

		
	}

	public void deleteOrganization(int id) {
		// TODO Auto-generated method stub
		organizationRepository.deleteById(id);
		
	}
	

	

}
