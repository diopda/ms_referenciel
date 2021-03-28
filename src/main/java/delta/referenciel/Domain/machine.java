package delta.referenciel.Domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class machine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String nom;
	private String type;
	private Long fraisdepanage;
	private Long consommationGazoil;
	private Long fraisEntretien;
	private Long recette;
	private Long saison;
	@Column (nullable = true)
	private Long idUnion;
	@Column (nullable = true)
	private Long idCuvette;
	@Column (nullable = false)
	private Long idConducteur;
	
	

}
