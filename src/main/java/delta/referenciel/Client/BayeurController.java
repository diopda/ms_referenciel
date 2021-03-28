package delta.referenciel.Client;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BayeurController {
	
	@Autowired
	BayeurService bayeurService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/bayeurs")
	public Iterable<Bayeur> getBayeurs() {
		return bayeurService.getBayeur();
	}
	

}
