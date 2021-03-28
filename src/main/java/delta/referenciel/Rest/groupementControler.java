package delta.referenciel.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import delta.referenciel.Domain.Groupement;
import delta.referenciel.Service.groupementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class groupementControler {
	

	@Autowired
    private groupementService groupementService;

	
	@RequestMapping(value = "/groupements", method = RequestMethod.POST)
	public Groupement createGroupement(@RequestBody Groupement groupement) {

		return groupementService.saveGroupement(groupement);
	}


	
	@RequestMapping(value = "/groupements/{id}", method = RequestMethod.GET)
	public Groupement getGroupement(@PathVariable("id") final Long id) {
		Optional<Groupement> groupement = groupementService.getGroupement(id);
		if(groupement.isPresent()) {
			return groupement.get();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/sectionGroupements/{id}", method = RequestMethod.GET)
	public Iterable <Groupement> getgroupement(@PathVariable("id") final Long id) {
		Iterable<Groupement> groupement = groupementService.getgroupement(id);
		if(groupement.iterator().hasNext()) {
			return groupement;
		} else {
			return null;
		}
	}


	@RequestMapping(value = "/groupements", method = RequestMethod.GET)
	public Iterable<Groupement> getGroupement() {

		return groupementService.getGroupement();
	}


	@RequestMapping(value = "/groupements/{id}", method = RequestMethod.PUT)
	public Groupement updateCuvette(@PathVariable("id") final Long id, @RequestBody Groupement groupement) {
		Optional<Groupement> g = groupementService.getGroupement(id);
		if(g.isPresent()) {
			Groupement nouveaugroupement = g.get();
			
			String nom =groupement.getNom();
			if(nom != null) {
				nouveaugroupement.setNom(nom);
			}
			
			
			Long nbrepaysan = groupement.getNbrePaysan();
			if(nbrepaysan != null) {
				nouveaugroupement.setNbrePaysan(nbrepaysan);
			}
			String chef = groupement.getChef();
			if(chef != null) {
				nouveaugroupement.setChef(chef);;
			}
			
			
			 Long superficie = groupement.getSuperficieAtt();
				
				if(superficie != null) {
					nouveaugroupement.setSuperficieAtt(superficie);;
				}
			groupementService.saveGroupement(nouveaugroupement);
			return nouveaugroupement;
		} else {
			return null;
		}
	}


	
	@RequestMapping(value = "/groupements/{id}", method = RequestMethod.DELETE)
	public void deleteGroupement(@PathVariable("id") final Long id) {
		groupementService.deleteGroupement(id);
	}


}
