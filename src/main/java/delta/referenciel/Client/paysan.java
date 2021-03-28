package delta.referenciel.Client;

import lombok.Data;

@Data
public class paysan {
    private Long id;
    private String reference;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;
    private String fonction;
    private Long  IdGroupement;
    private float superficie;
}
