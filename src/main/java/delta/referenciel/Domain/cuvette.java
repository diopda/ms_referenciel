package delta.referenciel.Domain;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cuvette {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Long nbreUnion;
	private String president;
	private String tresorier;
	private String tresorierAdj;
	private String secretaireG;
	private String secretaireGADJ;
	private Long superficie;

	@JsonIgnore
	@OneToMany( targetEntity=village.class, mappedBy="cuvette" )
	private List<village> villages = new ArrayList<>();

}
