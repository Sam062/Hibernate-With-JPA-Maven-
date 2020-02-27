package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stdtab")
@PrimaryKeyJoinColumn(name = "sid")
public class Student extends Person {
	@Column(name = "sfee")
	private Double stdFee;
	@Column(name = "grd")
	private String stdGrd;
	public Student() {
		super();
	}
	public Double getStdFee() {
		return stdFee;
	}
	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}
	public String getStdGrd() {
		return stdGrd;
	}
	public void setStdGrd(String stdGrd) {
		this.stdGrd = stdGrd;
	}
	@Override
	public String toString() {
		return "Student [stdFee=" + stdFee + ", stdGrd=" + stdGrd + "]";
	}
}
