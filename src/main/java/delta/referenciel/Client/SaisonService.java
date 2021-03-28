package delta.referenciel.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-referenciel",url = "http://localhost:8083")
public interface SaisonService {

	@GetMapping(path = "/saisons",produces = "application/json")
	Iterable<Saison> getSaison();

}
