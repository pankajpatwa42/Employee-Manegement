package Employee.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
public class Assets {
	
	
	@ManyToOne
	private Organization organization;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assestId;
	
	@NotEmpty(message = "asset name not be empty")
	private String assetName;
//	@NotEmpty(message = "Date not be empty or date format in yyyy-mm-dd")
	private Date issueDate; 
	
	
	
	
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public int getAssestId() {
		return assestId;
	}
	public void setAssestId(int assestId) {
		this.assestId = assestId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	
	
	
	
}
