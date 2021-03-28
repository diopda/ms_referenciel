package delta.referenciel.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class magasin {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String reference;
	private String nom;
	private Long stocksemenceT;
	private Long stocksemenceNt;
	private Long stockengraisUree;
	private Long stockengraisDap;
    private Long stockHerbicideP;
    private Long stockHerbicideW;
    private Long stockHerbicideL;
    private Long stockHerbicideG;
    private Long stockHerbicideT;
    private Long stockPaddyR;
    private String referenceGestionnaire;
    private Long unionproprietaire;
    
	

}
