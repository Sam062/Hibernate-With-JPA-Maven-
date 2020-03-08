package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Data
@Entity
public class ModelClass {
	@Id
	private Integer eid;
	@NaturalId
	private String ecode;

}
