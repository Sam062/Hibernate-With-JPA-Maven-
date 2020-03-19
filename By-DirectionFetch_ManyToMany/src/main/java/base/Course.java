package base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Course {
	@Id
	private Integer cid;
	private String code;
	
	//In case of ManyToMany, mappedBy always written in child class hasA var multiplicity level
	@ManyToMany(mappedBy = "crsObj")
	private List<Student> stdObj;
	

}
