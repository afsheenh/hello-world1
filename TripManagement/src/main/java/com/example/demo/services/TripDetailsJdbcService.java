package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerTrip;

@Service
public class TripDetailsJdbcService {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public List<Map<String,Object>> getAll(){
		String sql = "select * from CustomerTripsTable";
		return this.template.queryForList(sql);
	}

	
	@Secured("ROLE_ADMIN")
	public CustomerTrip addTrip(CustomerTrip trip) throws Exception{
		String sql="insert into CustomerTripsTable values(?,?,?,?,?)";
		int rowAdded = this.template.update(sql, trip.getTripId(),trip.getSource(),trip.getDestination(),trip.getTripAmount(),trip.getTripDate());
		if(rowAdded==1) {
			return trip;
		}
		else {
			throw new Exception("Data Not Inserted");
		}
	}
	
	public CustomerTrip deleteTrip(CustomerTrip entity) throws Exception{
		String sql = "delete from CustomerTripsTable where tripid=? ";
		int rowDeleted = this.template.update(sql, entity.getTripId());
		if(rowDeleted==1) {
			return entity;
		}
		else {
			throw new Exception("Trip not Deleted");
		}
	}
	
}
