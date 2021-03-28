package delta.referenciel.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import delta.referenciel.Domain.cuvette;
import delta.referenciel.Service.cuvetteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class cuvetteControler {
	

	@Autowired
    private cuvetteService cuvetteService;
	
	
	@RequestMapping(value = "/cuvettes", method = RequestMethod.POST,produces = "application/json")
	public cuvette createCuvette(@RequestBody cuvette cuvette) {

		return cuvetteService.saveCuvette(cuvette);
	}


	
	@RequestMapping(value = "/cuvettes/{id}", method = RequestMethod.GET,produces = "application/json")
	public cuvette getCuvette(@PathVariable("id") final Long id) {
		Optional<cuvette> cuvette = cuvetteService.getCuvette(id);
		if(cuvette.isPresent()) {
			return cuvette.get();
		} else {
			return null;
		}
	}

	
	@RequestMapping(value = "/cuvettes", method = RequestMethod.GET,produces = "application/json")
	public Iterable<cuvette> getCuvettes() {

		return cuvetteService.getCuvettes();
	}

	@RequestMapping(value = "/cuvettes/{id}", method = RequestMethod.PUT,produces = "application/json")
	public cuvette updateCuvette(@PathVariable("id") final Long id, @RequestBody cuvette cuvette) {
		Optional<cuvette> c = cuvetteService.getCuvette(id);
		if(c.isPresent()) {
			cuvette nouveauCuvette = c.get();
			
			String nom =cuvette.getNom();
			if(nom != null) {
				nouveauCuvette.setNom(nom);
			}
			
			
			Long nbreunion = cuvette.getNbreUnion();
			if(nbreunion != null) {
				nouveauCuvette.setNbreUnion(nbreunion);
			}
			String president = cuvette.getPresident();
			if(president != null) {
				nouveauCuvette.setPresident(president);;
			}
			
			String tresorier = cuvette.getTresorier();
			if(tresorier != null) {
				nouveauCuvette.setTresorier(tresorier);;
			}
			String tresorierAdj = cuvette.getTresorierAdj();
			
			if(tresorierAdj != null) {
				nouveauCuvette.setTresorierAdj(tresorierAdj);;
			}
            String secretaireG = cuvette.getSecretaireG();
			
			if(secretaireG != null) {
				nouveauCuvette.setSecretaireG(secretaireG);;
			}
            String secretaireGAdj = cuvette.getSecretaireGADJ();
			
			if(secretaireGAdj != null) {
				nouveauCuvette.setSecretaireGADJ(secretaireGAdj);;
			}
			 Long superficie = cuvette.getSuperficie();
				
				if(superficie != null) {
					nouveauCuvette.setSuperficie(superficie);;
				}
			cuvetteService.saveCuvette(nouveauCuvette);
			return nouveauCuvette;
		} else {
			return null;
		}
	}


	
	@RequestMapping(value = "/cuvettes/{id}", method = RequestMethod.DELETE)
	public void deleteCuvette(@PathVariable("id") final Long id) {

		cuvetteService.deleteCuvette(id);
	}


}
