package base;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@GenericGenerator(name = "A",strategy = "increment")
public class Student {
	@Id
	private Integer sid;
	private String sname;

	@ElementCollection
	@CollectionTable(name = "studentmark",joinColumns = @JoinColumn(name="sid"))
	@CollectionId(
			columns = @Column(name = "unqID"),
			generator = "A",
			type = @Type(type = "long")
			)
	private List<Integer> smark;
}
