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

import delta.referenciel.Domain.machine;
import delta.referenciel.Service.machineService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class machineControler {
	
	@Autowired
    private machineService machineService;
	
	
	@PostMapping("/machines")
	public machine createMachine(@RequestBody machine machine) {
		return machineService.saveMachine(machine);
	}
	
	

	@GetMapping("/machines/{id}")
	public machine getMachine(@PathVariable("id") final Long id) {
		Optional<machine> machine = machineService.getMachine(id);
		if(machine.isPresent()) {
			return machine.get();
		} else {
			return null;
		}
	}
	
	
	@GetMapping("/machines")
	public Iterable<machine> getMachines() {
		return machineService.getMachine();
	}
	
	
	@PutMapping("/machines/{id}")
	public machine updateMachine(@PathVariable("id") final Long id, @RequestBody machine machine) {
		Optional<machine> m = machineService.getMachine(id);
		if(m.isPresent()) {
			machine nouveauMachine = m.get();
			
			String matricule =machine.getMatricule();
			if(matricule != null) {
				nouveauMachine.setMatricule(matricule);
			}
			
			String nom = machine.getNom();
			if(nom != null) {
				nouveauMachine.setNom(nom);
			}
			String type =machine.getType();
			if(type != null) {
				nouveauMachine.setType(type);;
			}
			
			 Long depanage = machine.getFraisdepanage();
				
				if(depanage != null) {
					nouveauMachine.setFraisdepanage(depanage);;
			}
				
			 Long gazoil = machine.getConsommationGazoil();
					
				if(gazoil != null) {
					nouveauMachine.setConsommationGazoil(gazoil);;
			}
			 Long entretien = machine.getFraisEntretien();
					
				if(entretien != null) {
					nouveauMachine.setFraisEntretien(entretien);;
			}
			 Long recette = machine.getRecette();
					
				if(recette != null) {
				   nouveauMachine.setRecette(recette);;
			}
			Long saison = machine.getSaison();
					
			    if(saison != null) {
					nouveauMachine.setSaison(saison);;
			}
			machineService.saveMachine(nouveauMachine);
			return nouveauMachine;
		} else {
			return null;
		}
	}
	
	

	@DeleteMapping("/machines/{id}")
	public void deleteMachine(@PathVariable("id") final Long id) {
		machineService.deleteMachine(id);
	}


}
