package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mergeorupdatetest")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;
}
