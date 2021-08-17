package br.com.leomanzini.time.control.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {
	
	private Long id;
	private String description;
	private String cnpj;
	private String address;
	private String district;
	private String city;
	private String state;
	private String phone;
}
