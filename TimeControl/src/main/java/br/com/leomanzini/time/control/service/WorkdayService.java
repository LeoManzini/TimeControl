package br.com.leomanzini.time.control.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.time.control.models.Workday;
import br.com.leomanzini.time.control.repository.WorkdayRepository;

@Service
public class WorkdayService {
	
	@Autowired
	private WorkdayRepository workdayRepository;
	
	// When the JPA method save an object, it automatically returns the added object
	public Workday saveWorkday(Workday workday) {
		return workdayRepository.save(workday);
	}
	
	// Returns a list with all the workdays found at database
	public List<Workday> getAllWorkdays() {
		return workdayRepository.findAll();
	}
	
	// Returns a specific workday, the Optional<Workday> is case we cant found the id at database
	public Optional<Workday> getWorkdayById(Long workdayId) {
		return workdayRepository.findById(workdayId);
	}
	
	// Update a specific workday, if it exists
	public Workday updateWorkday(Workday workday) throws Exception {
		
		if(workdayRepository.existsById(workday.getId())) {
			return workdayRepository.save(workday);
		} else {
			throw new NoSuchMethodException("Workday not found by this ID: " + workday.getId());
		}
	}
	
	// Delete a specific workday, if it exists
	public void deleteWorkday(Long workdayId) throws Exception {
		if(workdayRepository.existsById(workdayId)) {
			workdayRepository.deleteById(workdayId);
		} else {
			throw new NoSuchMethodException("Workday not found by this ID: " + workdayId);
		}
	}
}
