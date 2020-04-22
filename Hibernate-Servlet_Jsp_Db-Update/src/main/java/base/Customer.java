package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	private Integer cid;
	private String cname;
	private Double csal;

}
