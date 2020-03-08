package base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	private Integer bid;
	private String bname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pidFk")
	private PublisherInfo pob;

}
