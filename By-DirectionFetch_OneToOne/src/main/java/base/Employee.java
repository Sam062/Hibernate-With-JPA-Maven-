package base;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pidFK",unique = true)
	private Profile profObj;

}
