package br.com.leomanzini.time.control.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MyCalendar {
	
	@Id
	private Long id;
	
	@OneToOne(targetEntity=DateType.class, fetch=FetchType.EAGER)
	private DateType dateType;
	private String description;
	private LocalDateTime date;
}
