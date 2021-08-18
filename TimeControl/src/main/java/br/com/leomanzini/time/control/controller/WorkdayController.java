package br.com.leomanzini.time.control.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leomanzini.time.control.models.Workday;

@RestController
@RequestMapping("/workday")
public class WorkdayController {
	
	@PostMapping
	public Workday createWorkday() {
		return null;
	}
}
