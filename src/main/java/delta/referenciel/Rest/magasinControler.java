package delta.referenciel.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import delta.referenciel.Domain.magasin;
import delta.referenciel.Service.magasinService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class magasinControler {
	
	@Autowired
    private magasinService magasinService;
	
	@PostMapping("/magasins")
	public magasin createMagasin(@RequestBody magasin magasin) {
		return magasinService.saveMagasin(magasin);
	}
	
	

	@GetMapping("/magasins/{id}")
	public magasin getMagasin(@PathVariable("id") final Long id) {
		Optional<magasin> magasin = magasinService.getMagasin(id);
		if(magasin.isPresent()) {
			return magasin.get();
		} else {
			return null;
		}
	}
	
	
	@GetMapping("/magasins")
	public Iterable<magasin> getMagasin() {
		return magasinService.getMagasin();
	}
	
	
	@PutMapping("/magasins/{id}")
	public magasin updateMagasin(@PathVariable("id") final Long id, @RequestBody magasin magasin) {
		Optional<magasin> m = magasinService.getMagasin(id);
		if(m.isPresent()) {
			magasin nouveauMagasin = m.get();
			
			String reference =magasin.getReference();
			if(reference != null) {
				nouveauMagasin.setReference(reference);
			}
			
			String nom = magasin.getNom();
			if(nom != null) {
				nouveauMagasin.setNom(nom);
			}
			Long semencetrier =magasin.getStocksemenceT();
			if(semencetrier != null) {
				nouveauMagasin.setStocksemenceT(semencetrier);;
			}
			 Long semencenT = magasin.getStocksemenceNt();
				
				if(semencenT != null) {
					nouveauMagasin.setStocksemenceNt(semencenT);;
			}
				
			 Long engraisUree = magasin.getStockengraisUree();
					
				if(engraisUree != null) {
					nouveauMagasin.setStockengraisUree(engraisUree);;
			}
			 Long engraisDap = magasin.getStockengraisDap();
					
				if(engraisDap != null) {
					nouveauMagasin.setStockengraisDap(engraisDap);;
			}
			 Long herbicideP = magasin.getStockHerbicideP();
					
				if(herbicideP != null) {
				   nouveauMagasin.setStockHerbicideP(herbicideP);;
			}
			Long herbicideW = magasin.getStockHerbicideW();
					
				if(herbicideW != null) {
			       nouveauMagasin.setStockHerbicideW(herbicideW);;
			
				}
			Long herbicideL = magasin.getStockHerbicideL();
					
					if(herbicideL != null) {
					   nouveauMagasin.setStockHerbicideL(herbicideL);;
				}
             Long herbicideG = magasin.getStockHerbicideG();
					
					if(herbicideG != null) {
					   nouveauMagasin.setStockHerbicideG(herbicideG);;
				}
              Long herbicideT = magasin.getStockHerbicideT();
					
					if(herbicideT != null) {
					   nouveauMagasin.setStockHerbicideT(herbicideT);;
				}
              Long paddyRembourser = magasin.getStockPaddyR();
					
					if(paddyRembourser != null) {
					   nouveauMagasin.setStockPaddyR(paddyRembourser);;
				}
			String referenceGestionnaire = magasin.getReferenceGestionnaire();

			if(referenceGestionnaire != null) {
				nouveauMagasin.setReferenceGestionnaire(referenceGestionnaire);;
			}
			Long union = magasin.getUnionproprietaire();

			if(union != null) {
				nouveauMagasin.setUnionproprietaire(union);;
			}
			magasinService.saveMagasin(nouveauMagasin);
			return nouveauMagasin;
		} else {
			return null;
		}
	}
	
	
	
	@DeleteMapping("/magasins/{id}")
	public void deleteMagasin(@PathVariable("id") final Long id) {
		magasinService.deleteMagasin(id);
	}


}
