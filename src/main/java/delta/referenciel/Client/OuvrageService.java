package delta.referenciel.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-agriculture",url = "http://localhost:8083")
public interface OuvrageService {

	 @GetMapping(path = "/ouvrages",produces = "application/json")
	Iterable<Ouvrage> getOuvrage();

}
