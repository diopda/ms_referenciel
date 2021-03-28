package delta.referenciel.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;




@FeignClient(name = "ms-agriculture",url = "http://localhost:8083")
public interface MaintenanceService {

	 @GetMapping(path = "/maintenances",produces = "application/json")
	Iterable<Maintenance> getMaintenance();
	
	

}
