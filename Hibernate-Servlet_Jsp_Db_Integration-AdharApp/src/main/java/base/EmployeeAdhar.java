package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity
public class EmployeeAdhar {
	@Id
	@Column(name = "AdharNo")
	@GeneratedValue(generator="eid")
	@GenericGenerator(name = "eid",strategy = "increment")
	private Integer empID;

	@Column(name = "NAME")
	private String empName;

	@Column(name = "SALARY")
	private Double empSal;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CONTACT")
	private String mobileNo;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "DEPT")
	private String department;

	@Column(name = "ADDRESS")
	private String address;
}
