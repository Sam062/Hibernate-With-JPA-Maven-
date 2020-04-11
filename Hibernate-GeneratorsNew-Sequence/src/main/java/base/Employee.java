package base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data 
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "abc")
	@SequenceGenerator(name = "abc",sequenceName = "DEMO_SEQ",initialValue = 100,allocationSize = 5)
	private Integer eid;
	private String ename;
	private Double esal;

}
