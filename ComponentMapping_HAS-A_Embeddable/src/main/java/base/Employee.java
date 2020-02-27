package base;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emptab")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "hno",column = @Column(name="emphno")),
		@AttributeOverride(name = "loc",column = @Column(name="emploc"))
	})
	private Address addr;
	public Employee() {
		super();
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", addr=" + addr + "]";
	}
	

}
