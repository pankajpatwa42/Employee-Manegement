package Employee.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.Exception.ResourceNotFoundException;
import Employee.Models.Assets;
import Employee.Models.Organization;
import Employee.Repository.AssestsRepository;
import Employee.Repository.OrganizationRepository;

@Service
public class AssestsServiceImpl implements AssestsService {
	
	@Autowired
	private AssestsRepository assestsRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Assets saveAssets(Assets assets) {
		// TODO Auto-generated method stub
		Organization org = organizationRepository.findById(2).orElseThrow(null);
		assets.setOrganization(org);
		return assestsRepository.save(assets);
	}

	@Override
	public List<Assets> getAllAssets() {
		// TODO Auto-generated method stub
		return assestsRepository.findAll();
	}

	@Override
	public Assets getAssetsById(int id) {
		// TODO Auto-generated method stub
		return assestsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Assests","ID",id));
	}

	@Override
	public Assets updateAssets(Assets assets, int id) {
		// TODO Auto-generated method stub
		Assets existingAssests = assestsRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Assest","ID",id));
		existingAssests.setAssetName(assets.getAssetName());
		existingAssests.setIssueDate(assets.getIssueDate());
		assestsRepository.save(existingAssests);
		return existingAssests;
	}

	@Override
	public void deleteAssets(int id) {
		// TODO Auto-generated method stub
		assestsRepository.deleteById(id);
		
	}

}
