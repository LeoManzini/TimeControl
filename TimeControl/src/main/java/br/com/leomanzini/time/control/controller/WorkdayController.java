package br.com.leomanzini.time.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PutMapping
	public Workday updateWorkday(@RequestBody Workday workday) throws Exception {
		return workdayService.updateWorkday(workday);
	}
	
	@DeleteMapping
	public void deleteWorkday(@RequestBody Workday workday) throws Exception {
		workdayService.deleteWorkday(workday);
	}
}
