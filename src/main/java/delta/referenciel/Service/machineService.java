package delta.referenciel.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import delta.referenciel.Domain.machine;

import delta.referenciel.Repository.machineRepository;

@Service
public class machineService {
	
	@Autowired
	private machineRepository machineRepository;
	
	public Optional<machine> getMachine(final Long id) {
		return machineRepository.findById(id);
	}
	
	public Iterable<machine> getMachine() {
		return machineRepository.findAll();
	}
	
	public void deleteMachine(final Long id) {
		machineRepository.deleteById(id);
	}
	
	public machine saveMachine(machine machine) {
		machine savedmachine = machineRepository.save(machine);
		return savedmachine;
	}

}
