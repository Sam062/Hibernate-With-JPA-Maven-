package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
@DynamicInsert
public class ModelClass {
	@Id
	private Integer emopId;
	private String empName;
	private Double empSal;

}
