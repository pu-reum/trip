package com.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.dto.Placedet;
import com.trip.frame.MyService;
import com.trip.mapper.PlacedetMapper;

@Service
public class PlacedetService implements MyService<Integer, Placedet>{
	
	@Autowired
	PlacedetMapper mapper;

	@Override
	public void register(Placedet v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Placedet v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Placedet get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Placedet> get() throws Exception {
		return mapper.selectall();
	}
	
	
	
	
	
	
	
	
	
	
}
