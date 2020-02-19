package base;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "emptab")
public class ModelClass {
	@Id
	private Integer eid;
	private String ename;

	@ElementCollection
	@CollectionTable(name = "empprjstab",joinColumns = @JoinColumn(name="eid"))
	@Column(name = "prj")
	private Set<String> prj;

	public ModelClass() {
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

	public Set<String> getPrj() {
		return prj;
	}

	public void setPrj(Set<String> prj) {
		this.prj = prj;
	}

	@Override
	public String toString() {
		return "ModelClass [eid=" + eid + ", ename=" + ename + ", prj=" + prj + "]";
	}
	

}
