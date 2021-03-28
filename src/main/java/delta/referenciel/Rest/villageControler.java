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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import delta.referenciel.Domain.village;
import delta.referenciel.Service.villageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class villageControler {
	

	@Autowired
    private villageService villageService;
	
	
	@RequestMapping(value = "/villages", method = RequestMethod.POST,produces = "application/json")
	public village createVillage(@RequestBody village village) {

		return villageService.saveVillage(village);
	}
	
	
	
	@GetMapping("/villages/{id}")
	public village getVillage(@PathVariable("id") final Long id) {
		Optional<village> village = villageService.getVillage(id);
		if(village.isPresent()) {
			return village.get();
		} else {
			return null;
		}
	}
	

	@RequestMapping(value = "/villages", method = RequestMethod.GET,produces = "application/json")
	public Iterable<village> getVillages() {

		return villageService.getVillages();
	}
	
	
	@PutMapping("/villages/{id}")
	public village updateVillage(@PathVariable("id") final Long id, @RequestBody village village) {
		Optional<village> v = villageService.getVillage(id);
		if(v.isPresent()) {
			village nouveauVillage = v.get();
			
			String nom = village.getNom();
			if(nom != null) {
				nouveauVillage.setNom(nom);
			}
			
			Long population = village.getPopulation();
			if(population != null) {
				nouveauVillage.setPopulation(population);
			}
			Long populationAtt = village.getPopulationAtt();
			if(populationAtt != null) {
				nouveauVillage.setPopulationAtt(populationAtt);;
			}

			Float superficieEx = village.getSuperficieEx();
			if(superficieEx != null) {
				nouveauVillage.setSuperficieEx(superficieEx);;
			}
			Float superficiePh = village.getSuperficiePH();
			
			if(superficiePh != null) {
				nouveauVillage.setSuperficiePH(superficiePh);;
			}
				
			villageService.saveVillage(nouveauVillage);
			return nouveauVillage;
		} else {
			return null;
		}
	}
	

	@DeleteMapping("/villages/{id}")
	public void deleteVillage(@PathVariable("id") final Long id) {
		villageService.deleteVillage(id);
	}
	

}
