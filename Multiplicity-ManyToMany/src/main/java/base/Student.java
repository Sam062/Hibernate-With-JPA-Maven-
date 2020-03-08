package base;

import java.util.List;

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
	private Integer stdId;
	private String stdNAme;
	private String stdMail;
	
	
	@ManyToMany
	@JoinTable(name = "studentcourseTab",
	joinColumns = @JoinColumn(name="stdIdFK"),
	inverseJoinColumns = @JoinColumn(name="cidFK")
	)
	private List<Course> obs;

}
