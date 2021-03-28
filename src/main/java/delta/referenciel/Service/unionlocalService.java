package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.Unionlocal;
import delta.referenciel.Repository.unionlocalRepository;

@Service
public class unionlocalService {
	
	@Autowired
	private unionlocalRepository unionRepository;
	
	public Optional<Unionlocal> getUnion(final Long id) {
		return unionRepository.findById(id);
	}
	
	public Iterable<Unionlocal> getUnion() {
		return unionRepository.findAll();
	}
	
	public void deleteUnion(final Long id) {
		unionRepository.deleteById(id);
	}
	
	public Unionlocal saveUnion(Unionlocal union) {
		Unionlocal savedunion = unionRepository.save(union);
		return savedunion;
	}

}
