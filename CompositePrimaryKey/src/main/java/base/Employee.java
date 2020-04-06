package base;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Employee {
	@EmbeddedId
	private EmpIdType eid;
	private String empName;
	private Double empSal;

}
