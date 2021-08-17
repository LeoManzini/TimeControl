package br.com.leomanzini.time.control.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence {
	
	private Long id;
	private String name;
	private String description;
}