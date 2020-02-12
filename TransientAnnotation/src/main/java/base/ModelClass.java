package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="producttable")
public class ModelClass {
	@Id
	@Column(name="pid")
	private Integer productId;

	@Column(name="pcode")
	private String productCode;
	
	@Column(name="pcost")
	private Double productCost;
	private Double gst;
	
	@Transient
	private Double mrp;
	public ModelClass() {
		super();
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Double getProductCost() {
		return productCost;
	}
	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "ModelClass [productId=" + productId + ", productCode=" + productCode + ", productCost=" + productCost
				+ ", gst=" + gst + ", mrp=" + mrp + "]";
	}
	
	
	
}
