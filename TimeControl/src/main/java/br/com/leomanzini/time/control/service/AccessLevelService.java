package br.com.leomanzini.time.control.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.time.control.models.AccessLevel;
import br.com.leomanzini.time.control.repository.AccessLevelRepository;

@Service
public class AccessLevelService {
	
	@Autowired
	private AccessLevelRepository accessLevelRepository;
	
	public AccessLevel saveAccessLevel(AccessLevel accessLevel) {
		return accessLevelRepository.save(accessLevel);
	}
	
	public List<AccessLevel> getAllAccessLevel() {
		return accessLevelRepository.findAll();
	}
	
	public Optional<AccessLevel> getAccessLevelById(Long accessLevelId) {
		return accessLevelRepository.findById(accessLevelId);
	}
	
	public AccessLevel updateAccessLevel(AccessLevel accessLevel) throws Exception {
		
		if(accessLevelRepository.existsById(accessLevel.getId())) {
			return accessLevelRepository.save(accessLevel);
		} else {
			throw new NoSuchMethodException("AccessLevel not found by this ID: " + accessLevel.getId());
		}
	}
	
	public void deleteAccessLevel(Long accessLevelId) throws Exception {
		if(accessLevelRepository.existsById(accessLevelId)) {
			accessLevelRepository.deleteById(accessLevelId);
		} else {
			throw new NoSuchMethodException("AccessLevel not found by this ID: " + accessLevelId);
		}
	}
}
