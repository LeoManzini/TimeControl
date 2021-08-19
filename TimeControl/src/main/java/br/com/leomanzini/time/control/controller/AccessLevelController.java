package br.com.leomanzini.time.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leomanzini.time.control.models.AccessLevel;
import br.com.leomanzini.time.control.service.AccessLevelService;

@RestController
@RequestMapping("/access")
public class AccessLevelController {
	
	@Autowired
	private AccessLevelService accessLevelService;
	
	@PostMapping
	public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel) {
		return accessLevelService.saveAccessLevel(accessLevel);
	}
	
	@GetMapping
	public List<AccessLevel> getAllAccessLevel() {
		return accessLevelService.getAllAccessLevel();
	}
	
	@GetMapping("/{access-level-id}")
	public ResponseEntity<AccessLevel> getAccessLevelById(@PathVariable("access-level-id") Long accessLevelId) throws Exception {
		return ResponseEntity.ok(accessLevelService.getAccessLevelById(accessLevelId).orElseThrow(() -> new NoSuchMethodException("Access level not found by this ID: " + accessLevelId)));
	}
	
	@PutMapping
	public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel) throws Exception {
		return accessLevelService.updateAccessLevel(accessLevel);
	}
	
	@DeleteMapping("/{access-level-id}")
	public HttpStatus deleteAccessLevel(@PathVariable("access-level-id") Long accessLevelId) {
		
		try {
			accessLevelService.deleteAccessLevel(accessLevelId);
			
		    return HttpStatus.OK;
		} catch (Exception e) {
			
			return HttpStatus.NOT_FOUND;
		}
	}
}
