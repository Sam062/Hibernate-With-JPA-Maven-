package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="secondaryTabdemo")
@SecondaryTables({
	@SecondaryTable(name = "proftab"),
	@SecondaryTable(name = "deptab",pkJoinColumns = @PrimaryKeyJoinColumn(name="eid"))
})
public class ModelClass {
	@Id
	@Column(name = "eid")
	private Integer empId;
	@Column(name = "ename")
	private String empName;
	@Column(name = "esal")
	private Double empSal;
	
	@Column(name = "prj",table = "proftab")
	private String empPrjs;
	@Column(name = "dpt",table = "deptab")
	private String empDept;
	public ModelClass() {
		super();
	}
	@Override
	public String toString() {
		return "ModelClass [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empPrjs=" + empPrjs
				+ ", empDept=" + empDept + "]";
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpPrjs() {
		return empPrjs;
	}
	public void setEmpPrjs(String empPrjs) {
		this.empPrjs = empPrjs;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	
}
