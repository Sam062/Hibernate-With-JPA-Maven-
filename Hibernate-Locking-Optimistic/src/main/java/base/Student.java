package base;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer sid;
	private String sname;
	private Double sfee;

	@Version
	private Integer vrsn;
}
