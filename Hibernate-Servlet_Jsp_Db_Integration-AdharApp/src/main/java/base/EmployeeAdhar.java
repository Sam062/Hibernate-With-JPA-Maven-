package base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

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

	@NotNull
	@Column(name = "NAME")
	private String empName;

	@NotNull
	@Column(name = "SALARY")
	private Double empSal;

	@NotNull
	@Column(name = "GENDER")
	private String gender;

	@NotNull
	@Size(min = 10,max = 13)
	@Column(name = "CONTACT")
	private String mobileNo;

	@Past
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@NotNull
	@Column(name = "DEPT")
	private String department;

	@NotNull
	@Column(name = "ADDRESS")
	private String address;
}
