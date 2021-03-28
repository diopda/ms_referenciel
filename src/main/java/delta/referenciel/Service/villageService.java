package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.village;
import delta.referenciel.Repository.villageRepository;

@Service
public class villageService {
	
	@Autowired
	private villageRepository villageRepository;
	
	public Optional<village> getVillage(final Long id) {
		return villageRepository.findById(id);
	}
	
	public Iterable<village> getVillages() {
		return villageRepository.findAll();
	}
	
	public void deleteVillage(final Long id) {
		villageRepository.deleteById(id);
	}
	
	public village saveVillage(village village) {
		village savedvillage = villageRepository.save(village);
		return savedvillage;
	}

}
