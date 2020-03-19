package base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private Integer sid;
	private String sname;
	private Double sfee;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "stdcrstab",
			joinColumns = @JoinColumn(name="sidFK"),
			inverseJoinColumns = @JoinColumn(name="cidFK"))
	private List<Course> crsObj;
	

}
