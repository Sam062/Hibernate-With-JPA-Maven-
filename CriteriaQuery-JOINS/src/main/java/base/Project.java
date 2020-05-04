package base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Project {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pcode;
	private String pinfo;

	@OneToMany(mappedBy = "prObj",fetch = FetchType.EAGER)
	private List<Student> stdObj;
}
