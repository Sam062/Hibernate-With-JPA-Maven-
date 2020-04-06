package base;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@Embeddable
public class EmpIdType implements Serializable{
	private Integer empId;
	private Integer deptId;
	

}
