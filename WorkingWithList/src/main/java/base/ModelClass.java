package base;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stdtab")
public class ModelClass {
	@Id
	@Column(name = "sid")
	private Integer stdid;
	@Column(name = "sname")
	private String stdName;
	
	@ElementCollection
	@CollectionTable(name = "stdmarks", joinColumns = @JoinColumn(name="sid"))
	@OrderColumn(name = "pos")
	@Column(name = "mrk")
	private List<Double> marks;

	public ModelClass() {
		super();
	}

	@Override
	public String toString() {
		return "ModelClass [stdid=" + stdid + ", stdName=" + stdName + ", marks=" + marks + "]";
	}

	public Integer getStdid() {
		return stdid;
	}

	public void setStdid(Integer stdid) {
		this.stdid = stdid;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public List<Double> getMarks() {
		return marks;
	}

	public void setMarks(List<Double> marks) {
		this.marks = marks;
	}
	
}
