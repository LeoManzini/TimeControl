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

import br.com.leomanzini.time.control.models.DateType;
import br.com.leomanzini.time.control.service.DateTypeService;

@RestController
@RequestMapping("/date-type")
public class DateTypeController {
	
	@Autowired
	private DateTypeService dateTypeService;
	
	@PostMapping
	public DateType createDateType(@RequestBody DateType dateType) {
		return dateTypeService.saveDateType(dateType);
	}
	
	@GetMapping
	public List<DateType> getAllDateType() {
		return dateTypeService.getAllDateType();
	}
	
	@GetMapping("/{date-type}")
	public ResponseEntity<DateType> getDateTypeById(@PathVariable("date-type") Long dateTypeId) throws Exception {
		return ResponseEntity.ok(dateTypeService.getDateTypeById(dateTypeId).orElseThrow(() -> new NoSuchMethodException("Date type not found by this ID: " + dateTypeId)));
	}
	
	@PutMapping
	public DateType updateDateType(@RequestBody DateType dateType) throws Exception {
		return dateTypeService.updateDateType(dateType);
	}
	
	@DeleteMapping("/{date-type}")
	public HttpStatus deleteAccessLevel(@PathVariable("date-type") Long dateTypeId) {
		
		try {
			dateTypeService.deleteDateType(dateTypeId);
			
		    return HttpStatus.OK;
		} catch (Exception e) {
			
			return HttpStatus.NOT_FOUND;
		}
	}
}
