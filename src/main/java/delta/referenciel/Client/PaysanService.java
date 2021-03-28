package delta.referenciel.Client;

import delta.referenciel.Domain.Groupement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-administration",url = "http://localhost:8081")
public interface PaysanService {
    @GetMapping(path = "/paysans",produces = "application/json")
    public List getPaysans();

    @GetMapping(path = "/paysanss/{id}",produces = "application/json")
    Iterable <paysan> getPaysanss(@PathVariable("id") Long id);


}
