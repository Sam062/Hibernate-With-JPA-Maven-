package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@Table(name = "MergeOrUpdateTest")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;

}
