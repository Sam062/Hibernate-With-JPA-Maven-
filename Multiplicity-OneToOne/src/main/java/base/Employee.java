package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private Integer empId;
	private String emmName;
	private Double empSal;
	
	@ManyToOne
	@JoinColumn(name = "panIdFK",unique = true)
	private PanCard pan;
}
