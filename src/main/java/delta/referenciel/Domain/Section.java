package delta.referenciel.Domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Section {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String nom;
	private  Long nbreGroupement;
	private  String president ;
	private  String vicePresident;
	private  String tresorier;
	private  String tresorierAdj;
	private  String secretaireG;
	private  String secretaireGadj;
	private  Long superficieAtt;


@JsonIgnore
	@OneToMany( targetEntity=Groupement.class, mappedBy="section" )
	private List<Groupement> groupements= new ArrayList<>();


@JsonIgnore
	@ManyToOne @JoinColumn(name="idUnionLocal", nullable=false)
	private Unionlocal unionlocal;




}
