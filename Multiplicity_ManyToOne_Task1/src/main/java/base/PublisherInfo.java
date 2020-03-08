package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class PublisherInfo {
	@Id
	private Integer pid;
	private String pname;
	private String paddr;

}
