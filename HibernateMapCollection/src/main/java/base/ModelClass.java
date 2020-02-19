package base;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
@Entity
@Table(name = "Comptab")
public class ModelClass {
	@Id
	private Integer cid;
	private String cname;
	private String addr;
	
	@ElementCollection
	@CollectionTable(name = "projstab",joinColumns = @JoinColumn(name="cid"))
	@MapKeyColumn(name = "projs")
	@Column(name = "vers")
	private Map<String,Double> projs;

	public ModelClass() {
		super();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Map<String, Double> getProjs() {
		return projs;
	}

	public void setProjs(Map<String, Double> projs) {
		this.projs = projs;
	}

	@Override
	public String toString() {
		return "ModelClass [cid=" + cid + ", cname=" + cname + ", addr=" + addr + ", projs=" + projs + "]";
	}
	
	

}
