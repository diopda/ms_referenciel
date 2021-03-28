package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.magasin;
import delta.referenciel.Repository.magasinRepository;

@Service
public class magasinService {
	
	@Autowired
	private magasinRepository magasinRepository;
	
	public Optional<magasin> getMagasin(final Long id) {
		return magasinRepository.findById(id);
	}
	
	public Iterable<magasin> getMagasin() {
		return magasinRepository.findAll();
	}
	
	public void deleteMagasin(final Long id) {
		magasinRepository.deleteById(id);
	}
	
	public magasin saveMagasin(magasin magasin) {
		magasin savedmagasin = magasinRepository.save(magasin);
		return savedmagasin;
	}

}
