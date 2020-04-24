package base;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
public class Projects {
	@Id
	private Integer pid;
	private String pname;

	@ElementCollection
	@CollectionTable(name = "prjstab",joinColumns = @JoinColumn(name="pid"))
	//@OrderColumn(name = "pos") Removed In case Of Bag Collection
	@Column(name = "prjs")
	private List<String> prjs;
}
