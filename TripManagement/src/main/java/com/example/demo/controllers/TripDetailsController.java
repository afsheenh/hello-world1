package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerTrip;
import com.example.demo.services.TripDetailsJdbcService;
import com.example.demo.services.TripDetailsService;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class TripDetailsController {

	@Autowired
	private TripDetailsService service;
	
	@Autowired
	private TripDetailsJdbcService jdbcService;
	
	@GetMapping(path="/trips")
	public List<CustomerTrip> getAll(){
		return this.service.getAll();
	}
	
	@PostMapping(path="/trips",produces="application/json" ,consumes="application/json")
	public CustomerTrip addTrip(@Valid @RequestBody CustomerTrip entity) throws Exception{
		
		return this.service.addTrip(entity);
	}
	
	@GetMapping(path="/tripsdb")
	public List<Map<String, Object>> getAllFromDB(){
		return this.jdbcService.getAll();
	
	}

	@PostMapping(path="/tripsdb",produces="application/json" ,consumes="application/json")
	public CustomerTrip addTripToDB(@Valid @RequestBody CustomerTrip entity) throws Exception{
		
		return this.jdbcService.addTrip(entity);
	}
	
	@DeleteMapping(path="/tripsdb",produces="application/json" ,consumes="application/json")
	public CustomerTrip deleteTripFromDB(@Valid @RequestBody CustomerTrip entity) throws Exception{
		
		return this.jdbcService.deleteTrip(entity);
	}
	
	
}
