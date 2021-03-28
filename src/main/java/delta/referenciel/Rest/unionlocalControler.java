package delta.referenciel.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import delta.referenciel.Domain.Unionlocal;
import delta.referenciel.Service.unionlocalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class unionlocalControler {
	

	@Autowired
    private unionlocalService unionService;
	

	@PostMapping("/unions")
	public Unionlocal createUnion(@RequestBody Unionlocal union) {
		return unionService.saveUnion(union);
	}
	
	
	
	@GetMapping("/unions/{id}")
	public Unionlocal getUnion(@PathVariable("id") final Long id) {
		Optional<Unionlocal> union = unionService.getUnion(id);
		if(union.isPresent()) {
			return union.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/unions")
	public Iterable<Unionlocal> getUnions() {
		return unionService.getUnion();
	}
	

	@PutMapping("/unions/{id}")
	public Unionlocal updateUnion(@PathVariable("id") final Long id, @RequestBody Unionlocal union) {
		Optional<Unionlocal> u = unionService.getUnion(id);
		if(u.isPresent()) {
			Unionlocal nouveauUnion = u.get();
			
			String nom =union.getNom();
			if(nom != null) {
				nouveauUnion.setNom(nom);
			}
			
			
			Long nbresection = union.getNbreSection();
			if(nbresection != null) {
				nouveauUnion.setNbreSection(nbresection);
			}
			String president = union.getPresident();
			if(president != null) {
				nouveauUnion.setPresident(president);;
			}
			String vicepresident = union.getVicePresident();
			if(vicepresident != null) {
				nouveauUnion.setVicePresident(vicepresident);
			}
			String tresorier = union.getTresorier();
			if(tresorier != null) {
				nouveauUnion.setTresorier(tresorier);;
			}
			String tresorierAdj = union.getTrsorierAdj();
			
			if(tresorierAdj != null) {
				nouveauUnion.setTrsorierAdj(tresorierAdj);;
			}
            String secretaireG = union.getSecretaireG();
			
			if(secretaireG != null) {
				nouveauUnion.setSecretaireG(secretaireG);;
			}
            String secretaireGAdj = union.getSecretaireGadj();
			
			if(secretaireGAdj != null) {
				nouveauUnion.setSecretaireGadj(secretaireGAdj);;
			}
			 Long superficieAtt = union.getSuperficieAtt();
				
				if(superficieAtt != null) {
					nouveauUnion.setSuperficieAtt(superficieAtt);;
				}
			unionService.saveUnion(nouveauUnion);
			return nouveauUnion;
		} else {
			return null;
		}
	}
	
	
	
	@DeleteMapping("/unions/{id}")
	public void deleteUnion(@PathVariable("id") final Long id) {
		unionService.deleteUnion(id);
	}
	

}
