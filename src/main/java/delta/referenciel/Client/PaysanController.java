package delta.referenciel.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaysanController {

    @Autowired
    private PaysanService paysanService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/paysans")
    public Iterable<paysan> getPaysans() {

        return paysanService.getPaysans();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/paysanss/{id}")
    public Iterable<paysan> getPaysanss(@PathVariable("id") final Long id) {
        Iterable<paysan> paysan = paysanService.getPaysanss(id);

        if (paysan.iterator().hasNext()) {
            return paysan;
        } else
            return null;

    }

}
