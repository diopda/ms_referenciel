package delta.referenciel.Client;

import java.util.Date;

import lombok.Data;

@Data     
public class Maintenance {
	  private Long id;
	    private  String intervention;
	    private  String frequence;
	    private  String prestataire;
	    private  Long  fraisMaintenance;
	    private  String type;
	    private  Date annee;

}
