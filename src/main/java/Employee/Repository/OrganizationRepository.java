package Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Employee.Models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer>{

}
