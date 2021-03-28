package delta.referenciel.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SaisonController {
	@Autowired
	SaisonService saisonService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	  @RequestMapping(value = "/saisons", method = RequestMethod.GET)
	    public Iterable<Saison> getSaison() {

	        return saisonService.getSaison();
	    }


}
