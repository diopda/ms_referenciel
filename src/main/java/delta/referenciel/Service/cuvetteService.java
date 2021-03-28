package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.cuvette;
import delta.referenciel.Repository.cuvetteRepository;


@Service
public class cuvetteService {
	
	@Autowired
	private cuvetteRepository cuvetteRepository;
	
	public Optional<cuvette> getCuvette(final Long id) {
		return cuvetteRepository.findById(id);
	}
	
	public Iterable<cuvette> getCuvettes() {
		return cuvetteRepository.findAll();
	}
	
	public void deleteCuvette(final Long id) {
		cuvetteRepository.deleteById(id);
	}
	
	public cuvette saveCuvette(cuvette cuvette) {
		cuvette savedcuvette = cuvetteRepository.save(cuvette);
		return savedcuvette;
	}

	


}
