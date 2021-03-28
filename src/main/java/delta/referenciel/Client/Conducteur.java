package delta.referenciel.Client;

import lombok.Data;

@Data
public class Conducteur {
	
	private Long id;
	private String reference;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String email;
	private String permiConduire;
	private String typeConducteur;
	private Long Machine;

}
