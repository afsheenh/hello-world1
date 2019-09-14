package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerTrip;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class TripDetailsService {
	
	@Autowired
	List<CustomerTrip> tripDetails;
	
	public List<CustomerTrip> getAll(){
		
		return this.tripDetails;
		
	}
	
	//In the CRUD operation this method will be "C"
	public CustomerTrip addTrip(CustomerTrip entity) throws Exception {
		
		boolean status = this.tripDetails.add(entity);
		if(status) {
			return entity;
		}
		else {
			throw new Exception("Element Not Added");
		}
	}
	
}
