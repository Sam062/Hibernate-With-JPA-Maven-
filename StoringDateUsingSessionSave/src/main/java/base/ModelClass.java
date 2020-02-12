package base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="prodtab")
public class ModelClass {
		@Id
		@Column(name="pid")
		private Integer prodId;
		@Column(name="pname")
		private String prodName;
		@Temporal(TemporalType.DATE)
		private Date mfgDate;
		@Temporal(TemporalType.TIME)
		private Date expDate;
		@Temporal(TemporalType.TIMESTAMP)
		private Date testSlot;
		public ModelClass() {
			super();
		}
		public Integer getProdId() {
			return prodId;
		}
		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public Date getMfgDate() {
			return mfgDate;
		}
		public void setMfgDate(Date mfgDate) {
			this.mfgDate = mfgDate;
		}
		public Date getExpDate() {
			return expDate;
		}
		public void setExpDate(Date expDate) {
			this.expDate = expDate;
		}
		public Date getTestSlot() {
			return testSlot;
		}
		public void setTestSlot(Date testSlot) {
			this.testSlot = testSlot;
		}
		@Override
		public String toString() {
			return "ModelClass [prodId=" + prodId + ", prodName=" + prodName + ", mfgDate=" + mfgDate + ", expDate="
					+ expDate + ", testSlot=" + testSlot + "]";
		}
		
		


}
