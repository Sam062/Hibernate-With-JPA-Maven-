package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emptab")
public class Employee extends Person {
	@Column(name = "esal")
	private Double empSal;
	@Column(name = "dept")
	private String empDept;
	public Employee() {
		super();
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	@Override
	public String toString() {
		return "Employee [empSal=" + empSal + ", empDept=" + empDept + "]";
	}
	
}
