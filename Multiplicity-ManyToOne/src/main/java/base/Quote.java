package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quote {
	@Id
	@Column(name = "qid")
	private Integer qteId;
	@Column(name = "minamt")
	private Double qteMinAmt;
	@Column(name = "qcode")
	private String qteCode;

}
