package br.com.leomanzini.time.control.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.time.control.models.DateType;
import br.com.leomanzini.time.control.repository.DateTypeRepository;

@Service
public class DateTypeService {
	
	@Autowired
	private DateTypeRepository dateTypeRepository;
	
	public DateType saveDateType(DateType dateType) {
		return dateTypeRepository.save(dateType);
	}
	
	public List<DateType> getAllDateType() {
		return dateTypeRepository.findAll();
	}
	
	public Optional<DateType> getDateTypeById(Long dateTypeId) {
		return dateTypeRepository.findById(dateTypeId);
	}
	
	public DateType updateDateType(DateType dateType) throws Exception {
		
		if(dateTypeRepository.existsById(dateType.getId())) {
			return dateTypeRepository.save(dateType);
		} else {
			throw new NoSuchMethodException("Date type not found by this ID: " + dateType.getId());
		}
	}
	
	public void deleteDateType(Long dateTypeId) throws Exception {
		
		if(dateTypeRepository.existsById(dateTypeId)) {
			dateTypeRepository.deleteById(dateTypeId);
		} else {
			throw new NoSuchMethodException("Date type not found by this ID: " + dateTypeId);
		}
	}
}
