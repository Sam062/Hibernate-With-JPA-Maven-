package base;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class PanCard {
	@Id
	private Integer panId;
	private String panNum;
	private String nameOnPan;

}
