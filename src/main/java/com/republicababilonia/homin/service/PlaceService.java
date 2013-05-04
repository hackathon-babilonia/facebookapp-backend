package com.republicababilonia.homin.service;

import java.util.List;

import com.republicababilonia.homin.to.PlaceTO;

public interface PlaceService {
	
	public void save(PlaceTO place);
	public void remove(Integer id);
	public void removeAll();
	
	public PlaceTO findPlaceById(Integer id);
	public List<PlaceTO> getPlaces(Integer universidade);
}
