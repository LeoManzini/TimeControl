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

import br.com.leomanzini.time.control.models.Workday;
import br.com.leomanzini.time.control.service.WorkdayService;

@RestController
@RequestMapping("/workday")
public class WorkdayController {
	
	@Autowired
	private WorkdayService workdayService;
	
	@PostMapping
	public Workday createWorkday(@RequestBody Workday workday) {
		return workdayService.saveWorkday(workday);
	}
	
	@GetMapping
	public List<Workday> getAllWorkdays() {
		return workdayService.getAllWorkdays();
	}
	
	@GetMapping("/{workdayid}")
	public ResponseEntity<Workday> getWorkdayById(@PathVariable("workdayid") Long workdayId) throws Exception {
		return ResponseEntity.ok(workdayService.getWorkdayById(workdayId).orElseThrow(() -> new NoSuchMethodException("Workday not found by this ID: " + workdayId)));
	}
	
	@PutMapping
	public Workday updateWorkday(@RequestBody Workday workday) throws Exception {
		return workdayService.updateWorkday(workday);
	}
	
	@DeleteMapping("/{workdayid}")
	public HttpStatus deleteWorkday(@PathVariable("workdayid") Long workdayId) {
		
		try {
			workdayService.deleteWorkday(workdayId);
			
		    return HttpStatus.OK;
		} catch (Exception e) {
			
			return HttpStatus.NOT_FOUND;
		}
	}
}
