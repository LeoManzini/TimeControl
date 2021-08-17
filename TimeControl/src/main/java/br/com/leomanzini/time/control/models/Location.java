package br.com.leomanzini.time.control.models;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	
	private Long id;
	
	@ManyToOne
	private AccessLevel accessLevel;
	private String description;
}
