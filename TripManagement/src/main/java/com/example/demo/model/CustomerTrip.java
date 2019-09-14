package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerTrip {
	
	private long tripId;
	@Size(min=3,max=15)
	private String source;
	@Size(min=3,max=15)
	private String destination;
	
	@DecimalMin("100.00")
	@DecimalMax("1500.00")
	private BigDecimal tripAmount;
	private LocalDate tripDate;
	
	

}
