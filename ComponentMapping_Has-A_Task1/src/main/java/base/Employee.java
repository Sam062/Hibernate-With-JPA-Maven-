package base;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpTask")
public class Employee {
	@Id
	private int eid;
	private String ename;
	@Embedded
	private EmployeeContract ec;
	public Employee() {
		super();
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public EmployeeContract getEc() {
		return ec;
	}
	public void setEc(EmployeeContract ec) {
		this.ec = ec;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", ec=" + ec + "]";
	}
	
}
