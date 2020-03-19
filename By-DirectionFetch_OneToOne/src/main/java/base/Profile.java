package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Profile {
	@Id
	private Integer pid;
	private String pname;
	
	@OneToOne(mappedBy = "profObj")
	private Employee empObj;

}
