package delta.referenciel.Rest;

import java.util.Optional;

import delta.referenciel.Domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import delta.referenciel.Service.sectionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class sectionControler {
	
	@Autowired
    private sectionService sectionService;

	@PostMapping("/sections")
	public Section createSection(@RequestBody Section section) {
		return sectionService.saveSection(section);
	}
	
	
	
	@GetMapping("/sections/{id}")
	public Section getSection(@PathVariable("id") final Long id) {
		Optional<Section> section = sectionService.getSection(id);
		if(section.isPresent()) {
			return section.get();
		} else {
			return null;
		}
	}
	

	@GetMapping("/sections")
	public Iterable<Section> getSections() {
		return sectionService.getSection();
	}
	
	
	@PutMapping("/sections/{id}")
	public Section updateSection(@PathVariable("id") final Long id, @RequestBody Section section) {
		Optional<Section> s = sectionService.getSection(id);
		if(s.isPresent()) {
			Section nouveauSection = s.get();
			
			String nom =section.getNom();
			if(nom != null) {
				nouveauSection.setNom(nom);
			}
			
			
			Long nbregroupement = section.getNbreGroupement();
			if(nbregroupement != null) {
				nouveauSection.setNbreGroupement(nbregroupement);
			}
			String president = section.getPresident();
			if(president != null) {
				nouveauSection.setPresident(president);;
			}
			String vicepresident = section.getVicePresident();
			if(vicepresident != null) {
				nouveauSection.setVicePresident(vicepresident);
			}
			String tresorier = section.getTresorier();
			if(tresorier != null) {
				nouveauSection.setTresorier(tresorier);;
			}
			String tresorierAdj = section.getTresorierAdj();
			
			if(tresorierAdj != null) {
				nouveauSection.setTresorierAdj(tresorierAdj);;
			}
            String secretaireG = section.getSecretaireG();
			
			if(secretaireG != null) {
				nouveauSection.setSecretaireG(secretaireG);;
			}
            String secretaireGAdj = section.getSecretaireGadj();
			
			if(secretaireGAdj != null) {
				nouveauSection.setSecretaireGadj(secretaireGAdj);;
			}
			 Long superficieAtt = section.getSuperficieAtt();
				
				if(superficieAtt != null) {
					nouveauSection.setSuperficieAtt(superficieAtt);;
				}
			sectionService.saveSection(nouveauSection);
			return nouveauSection;
		} else {
			return null;
		}
	}
	
	
	
	@DeleteMapping("/sections/{id}")
	public void deleteSection(@PathVariable("id") final Long id) {
		sectionService.deleteSection(id);
	}

}
