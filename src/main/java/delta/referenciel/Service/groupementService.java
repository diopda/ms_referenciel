package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.Groupement;

import delta.referenciel.Repository.groupementRepository;

@Service
public class groupementService {
	
	@Autowired
	private groupementRepository groupementRepository;
	
	public Optional<Groupement> getGroupement(final Long id) {
		return groupementRepository.findById(id);
	}
	
	public Iterable<Groupement> getGroupement() {
		return groupementRepository.findAll();
	}
	
	public void deleteGroupement(final Long id) {
		groupementRepository.deleteById(id);
	}
	
	public Groupement saveGroupement(Groupement groupement) {
		Groupement savedgroupement = groupementRepository.save(groupement);
		return savedgroupement;
	}

	public Iterable<Groupement> getgroupement(final Long id) {
		return groupementRepository.findBySection(id);
	}


}
