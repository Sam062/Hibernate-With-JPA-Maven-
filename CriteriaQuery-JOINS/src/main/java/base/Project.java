package base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Project {
	@Id
	@GeneratedValue
	private Integer pid;
	@NonNull
	private String pcode;
	@NonNull
	private String pinfo;

	@OneToMany(mappedBy = "prodObj")
	private List<Student> stdObj;
}
