package Employee.Models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Role {
	
	@Id
	private int roleId;
	
	private String roleName;
	
	public Role() {}

	public Role(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getReolId() {
		return roleId;
	}

	public void setReolId(int reolId) {
		this.roleId = reolId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	

}
