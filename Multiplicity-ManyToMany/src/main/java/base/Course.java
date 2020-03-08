package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Course {
	@Id
	private Integer crsId;
	private String crsCode;
	private Double crsFee;
}
