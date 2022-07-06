package Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Employee.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
