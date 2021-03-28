package delta.referenciel.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-agriculture",url = "http://localhost:8083")
public interface OrganeService {

	 @GetMapping(path = "/organes",produces = "application/json")
	Iterable<Organe> getOrgane();

}
