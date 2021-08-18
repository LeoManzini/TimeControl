package br.com.leomanzini.time.control.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Audited
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private IdMovimentation id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal period;
	
	@ManyToOne(targetEntity=Occurrence.class, fetch=FetchType.EAGER)
	private Occurrence occurrence;
	
	@ManyToOne(targetEntity=MyCalendar.class, fetch=FetchType.EAGER)
	private MyCalendar myCalendar;
}
