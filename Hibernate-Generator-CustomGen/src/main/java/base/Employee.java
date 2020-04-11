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
	@GeneratedValue(generator = "aaa")
	@GenericGenerator(name = "aaa",strategy = "base.EidGen")
	private String eid;
	private String ename;
	private Double esal;

}
