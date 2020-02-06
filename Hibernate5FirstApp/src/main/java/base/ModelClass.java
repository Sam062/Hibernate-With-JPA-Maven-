package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stdtab")
public class ModelClass {
	@Id
	@Column(name="sid")
	private Integer stdId;
	@Column(name="sname")
	private String stdName;
	@Column(name="sfee")
	private Double sdtFee;
	public ModelClass() {
		super();
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Double getSdtFee() {
		return sdtFee;
	}
	public void setSdtFee(Double sdtFee) {
		this.sdtFee = sdtFee;
	}
	@Override
	public String toString() {
		return "ModelClass [stdId=" + stdId + ", stdName=" + stdName + ", sdtFee=" + sdtFee + "]";
	}
	
	

}
