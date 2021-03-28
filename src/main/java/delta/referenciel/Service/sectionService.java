package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.Section;
import delta.referenciel.Repository.sectionRepository;

@Service
public class sectionService {
	
	@Autowired
	private sectionRepository sectionRepository;
	
	public Optional<Section> getSection(final Long id) {
		return sectionRepository.findById(id);
	}
	
	public Iterable<Section> getSection() {
		return sectionRepository.findAll();
	}
	
	public void deleteSection(final Long id) {
		sectionRepository.deleteById(id);
	}
	
	public Section saveSection(Section section) {
		Section savedsection = sectionRepository.save(section);
		return savedsection;
	}


}
