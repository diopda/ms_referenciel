package delta.referenciel.Domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class village {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Long population;
    private Long populationAtt;
    private Float superficieEx;
    private Float superficiePH;
   
   
    @ManyToOne @JoinColumn(name="idcuvette", nullable=true)
    private cuvette cuvette;

}
