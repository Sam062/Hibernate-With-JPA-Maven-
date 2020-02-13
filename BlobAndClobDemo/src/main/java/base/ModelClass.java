package base;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="stdtab")
public class ModelClass {
	@Id
	@Column(name="sid")
	private Integer stdId;
	@Column(name="sname")
	private String stdName;
	@Lob
	private byte[] stdImg;
	@Lob
	private char[] stdText;

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
	public byte[] getStdImg() {
		return stdImg;
	}
	public void setStdImg(byte[] stdImg) {
		this.stdImg = stdImg;
	}
	public char[] getStdText() {
		return stdText;
	}
	public void setStdText(char[] stdText) {
		this.stdText = stdText;
	}
	@Override
	public String toString() {
		return "ModelClass [stdId=" + stdId + ", stdName=" + stdName + ", stdImg=" + Arrays.toString(stdImg)
				+ ", stdText=" + Arrays.toString(stdText) + "]";
	}
	
}
