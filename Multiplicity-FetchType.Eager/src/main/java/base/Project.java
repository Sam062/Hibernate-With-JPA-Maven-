package base;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
	@Id
	private Integer pid;
	private String pname;
	
	//if fetchType is Default/Lazy then Multiple select query performed is HAS-A variable Involved.
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pidFK")
	private List<Module> obs;

}
