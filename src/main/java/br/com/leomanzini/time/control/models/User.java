package br.com.leomanzini.time.control.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne // Inside of users, X users can be associated to one category
	private UserCategory category;
	private String name;
	
	@ManyToOne // Same as category
	private Enterprise enterprise;
	
	@ManyToOne // One AccessLevel can have X users
	private AccessLevel accessLevel;
	
	@ManyToOne // Each worker with yours workday, but workday can have X workers
	private Workday workday;
	private BigDecimal tolerance;
	private LocalDateTime journeyStart;
	private LocalDateTime journeyEnd;
}
