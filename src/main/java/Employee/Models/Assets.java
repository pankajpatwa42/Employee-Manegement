package Employee.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Assets {
	
	
	@ManyToOne
	private Organization id;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assestId;
	private int furniture;
	private int laptop;
	private int chair;
	
	
	
	public Organization getId() {
		return id;
	}
	public void setId(Organization id) {
		this.id = id;
	}
	public int getAssestId() {
		return assestId;
	}
	public void setAssestId(int assestId) {
		this.assestId = assestId;
	}
	public int getFurniture() {
		return furniture;
	}
	public void setFurniture(int furniture) {
		this.furniture = furniture;
	}
	public int getLaptop() {
		return laptop;
	}
	public void setLaptop(int laptop) {
		this.laptop = laptop;
	}
	public int getChair() {
		return chair;
	}
	public void setChair(int chair) {
		this.chair = chair;
	}
	
	
	
	
}
