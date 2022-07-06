package Employee.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String resorceName;
	String fieldName;
	int fieldValue;
	
	public ResourceNotFoundException(String resorceName,String fieldName,int fieldValue)
	{
		
		super(String.format("%s not found with %s : %s", resorceName,fieldName,fieldValue));
		this.resorceName=resorceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		
	}
	
	

}
