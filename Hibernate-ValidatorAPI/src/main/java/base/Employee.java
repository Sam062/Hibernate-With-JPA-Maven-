package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private Integer eid;

	@NotNull
//	@Pattern(regexp = "[A-Z] {2,2}")
	@Size(min=1,max = 6,message = "name length must be between 1-6 chars")
	private String ename;
	@NotNull
	private Double esal;
}
