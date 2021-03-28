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
public class Unionlocal {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private  String nom;
	private  Long nbreSection;
	private String president;
	private  String vicePresident;
	private  String tresorier;
	private String trsorierAdj;
	private  String secretaireG;
	private  String secretaireGadj;
	private  Long superficieAtt;

	
	@OneToOne( cascade = CascadeType.ALL )
	@JoinColumn( name="idvillage" )
	private village village;

	@JsonIgnore
	@OneToMany( targetEntity=Section.class, mappedBy="unionlocal" )
	private List<Section> sections= new ArrayList<>();



}
