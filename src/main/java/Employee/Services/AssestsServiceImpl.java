package Employee.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.Exception.ResourceNotFoundException;
import Employee.Models.Assets;
import Employee.Repository.AssestsRepository;

@Service
public class AssestsServiceImpl implements AssestsService {
	
	@Autowired
	private AssestsRepository assestsRepository;

	@Override
	public Assets saveAssets(Assets assets) {
		// TODO Auto-generated method stub
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
		existingAssests.setFurniture(assets.getFurniture());
		existingAssests.setChair(assets.getChair());
		existingAssests.setLaptop(assets.getLaptop());
		assestsRepository.save(existingAssests);
		return existingAssests;
	}

	@Override
	public void deleteAssets(int id) {
		// TODO Auto-generated method stub
		assestsRepository.deleteById(id);
		
	}

}
