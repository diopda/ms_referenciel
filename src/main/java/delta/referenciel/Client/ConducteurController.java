package delta.referenciel.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConducteurController {
	
	@Autowired
	ConducteurService conducteurService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/conducteurs")
	public Iterable<Conducteur> getConducteurs() {
		return conducteurService.getConducteur();
	}

}
