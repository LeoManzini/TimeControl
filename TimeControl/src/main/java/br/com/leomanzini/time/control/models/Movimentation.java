package br.com.leomanzini.time.control.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movimentation {
	
	@Data
	@Embeddable
	@NoArgsConstructor
	@AllArgsConstructor
	public class IdMovimentation implements Serializable {
		private static final long serialVersionUID = 3465261450375508232L;
		
		private Long movimentationId;
		private Long userId;
	}
	
	@EmbeddedId
	private IdMovimentation id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal period;
	private Occurrence occurrence;
	private MyCalendar myCalendar;
}
