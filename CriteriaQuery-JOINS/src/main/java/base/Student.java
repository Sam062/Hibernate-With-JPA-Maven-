package base;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer sid;

	@NonNull
	private String sname;
	@NonNull
	private Double ssal;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PIDFK")
	private Project prodObj;
}
