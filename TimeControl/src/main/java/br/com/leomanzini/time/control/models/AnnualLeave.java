package br.com.leomanzini.time.control.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnnualLeave {
	
	@Data
	@Embeddable
	@NoArgsConstructor
	@AllArgsConstructor
	public class IdAnnualLeave implements Serializable {

		private static final long serialVersionUID = -8166512671194627096L;
		
		private Long annualLeaveId;
		private Long movimentationId;
		private Long userId;
	}
	
	@EmbeddedId
	private IdAnnualLeave id;
	private LocalDateTime workedDate;
	private BigDecimal hoursQuantity;
	private BigDecimal hoursBalance;
}
