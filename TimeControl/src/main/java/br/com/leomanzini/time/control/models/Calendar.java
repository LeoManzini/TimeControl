package br.com.leomanzini.time.control.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
	
	private Long id;
	private DateType dateType;
	private String description;
	private LocalDateTime date;
}
