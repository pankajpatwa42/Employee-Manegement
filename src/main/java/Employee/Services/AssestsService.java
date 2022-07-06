package Employee.Services;

import java.util.List;

import Employee.Models.Assets;


public interface AssestsService {
	
Assets saveAssets(Assets assets);
	
	List<Assets> getAllAssets();
	
	Assets getAssetsById(int id);
	
	Assets updateAssets(Assets assets,int id);
	
	void deleteAssets(int id);

}
