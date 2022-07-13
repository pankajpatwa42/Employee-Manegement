package Employee.Models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Assets {
	
	
	@JsonBackReference
	@ManyToOne
	private Organization organization;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assestId;
	
	@NotEmpty(message = "asset name not be empty")
	private String assetName;
	
//	@DateTimeFormat(pattern ="dd-mm-yyyy")
//	@JsonFormat(pattern = "yyyy/MM/dd")
//	private Date issueDate; 
	
	private int quantity;
	
	
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
