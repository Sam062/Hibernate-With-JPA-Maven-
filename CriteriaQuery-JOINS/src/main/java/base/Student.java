package base;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue
	private Integer sid;
	private String sname;
	private Double sfee;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Project prjs;

}
