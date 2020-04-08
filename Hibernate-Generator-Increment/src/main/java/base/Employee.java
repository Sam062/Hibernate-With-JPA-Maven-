package base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(generator = "eidgen")
	@GenericGenerator(name = "eidgen",strategy = "increment")
	private Integer eid;
	private String ename;
	private Double esal;

}
