package Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Employee.Models.Assets;

public interface AssestsRepository extends JpaRepository<Assets, Integer> {

}
