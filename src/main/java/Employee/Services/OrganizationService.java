package Employee.Services;

import java.util.List;

import Employee.Models.Organization;



public interface OrganizationService {
	
	Organization saveOrganization(Organization organization);
	
	List<Organization> getAllOrganization();
	
	Organization getOrganizationById(int id);
	
	Organization updateOrganization(Organization organization,int id);
	
	void deleteOrganization(int id);

}
