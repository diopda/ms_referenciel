package delta.referenciel.Domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

public class Groupement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String nom;
	private  Long nbrePaysan;
	private  String chef;
	private  Long superficieAtt;


	@ManyToOne @JoinColumn(name="idsection", nullable=false)
	private Section section;



}
