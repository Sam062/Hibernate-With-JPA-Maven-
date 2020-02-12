package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="custtab")
public class ModelClassCustomer {
	@Id
	@Column(name="cid")
	private Integer custId;
	@Column(name="cname")
	private String custName;
	@Column(name="csal")
	private Double custSal;
	public ModelClassCustomer() {
		super();
	}
	@Override
	public String toString() {
		return "ModelClassCustomer [custId=" + custId + ", custName=" + custName + ", custSal=" + custSal + "]";
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getCustSal() {
		return custSal;
	}
	public void setCustSal(Double custSal) {
		this.custSal = custSal;
	}

}
