package Employee.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "Organization name should be mentioned......")
	private String name;
	@NotEmpty(message = "Manager name reqiured!!!!!!")
	private String manager;
//	@NotEmpty(message = "Date should be their or Invalid Date Fromat (yyyy-mm-dd)")
	private Date established;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="organization")
	private List<Employee> employees = new ArrayList<>();    //one org have many employeess....
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy="organization")
	private List<Assets> assests = new ArrayList<>();    // one org have many assests p
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getEstablished() {
		return established;
	}
	public void setEstablished(Date established) {
		this.established = established;
	}
	
	
	
	

}
