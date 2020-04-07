package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries({
	@NamedQuery(name = "allEmps",query = "FROM base.Employee"),
	@NamedQuery(name="fetchEmps",query = "FROM base.Employee WHERE EID>=:A")
})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;

}
