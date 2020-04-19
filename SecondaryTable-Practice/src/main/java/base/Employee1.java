package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

import lombok.Data;

@Data
@Entity
@SecondaryTables({
	@SecondaryTable(name = "Employee2"),//Here No PKJoinColoumn so In Table, eid will be taken
	@SecondaryTable(name = "Employee3",
	pkJoinColumns = @PrimaryKeyJoinColumn(name="EMPID"))})//Here In Table, empId will be taken
public class Employee1 {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;

	@Column(name = "prjs",table = "Employee2")
	private String projects;
	@Column(name = "addr",table = "Employee3")
	private String address;

}
