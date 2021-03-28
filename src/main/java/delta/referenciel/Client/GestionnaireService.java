package delta.referenciel.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-administration",url = "http://localhost:8081")
public interface GestionnaireService {

	@GetMapping(path = "/gestionnaires",produces = "application/json")
	Iterable<Gestionnaire> getGestionnaire();

}
