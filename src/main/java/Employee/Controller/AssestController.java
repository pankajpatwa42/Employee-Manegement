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

import Employee.Models.Assets;
import Employee.Models.Organization;
import Employee.Repository.OrganizationRepository;
import Employee.Services.AssestsServiceImpl;

@RestController
@RequestMapping("/assets")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AssestController {
	
	@Autowired
	private AssestsServiceImpl assestsServiceImpl;
	
	@PostMapping("/saveassest")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Assets> saveAssets( @Valid @RequestBody  Assets Assets)
	{
		return new ResponseEntity<Assets>(assestsServiceImpl.saveAssets(Assets),HttpStatus.CREATED);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<Assets> getAllAssets(){return assestsServiceImpl.getAllAssets();}
	
	@GetMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Assets> getAssetsById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Assets>(assestsServiceImpl.getAssetsById(id),HttpStatus.OK);		
	}
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Assets> updateAssets(@PathVariable("id") int id,@Valid @RequestBody Assets assets)
	{
		return new ResponseEntity<Assets>(assestsServiceImpl.updateAssets(assets,id),HttpStatus.OK);		
	}
	
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteAssets (@PathVariable("id") int id) {
		assestsServiceImpl.deleteAssets(id);
		return  "Successfully Deleted";
	}


}
