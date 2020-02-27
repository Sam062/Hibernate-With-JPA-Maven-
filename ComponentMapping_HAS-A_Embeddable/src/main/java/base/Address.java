package base;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private Integer hno;
	private String loc;
	public Address() {
		super();
	}
	public Integer getHno() {
		return hno;
	}
	public void setHno(Integer hno) {
		this.hno = hno;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Address [hno=" + hno + ", loc=" + loc + "]";
	}

}
