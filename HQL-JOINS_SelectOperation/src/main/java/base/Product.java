package base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private Integer pid;
	private String pcode;
	private Double pcost;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pidFK")
	private List<Model> mods;

}
