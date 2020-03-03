package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Contract {
	@Id
	private Integer cntId;
	private String vendor;
	private String cntCode;
	
	@ManyToOne
	@JoinColumn(name = "qidFK")
	private Quote qob;

}
