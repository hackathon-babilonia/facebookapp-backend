package com.republicababilonia.homin.dao;

import java.util.List;

import com.republicababilonia.homin.to.PlaceTO;

public interface PlaceDAO {
	
	public List<PlaceTO> getPlaces(Integer universidade);
	
	public void save(PlaceTO place);
	public void remove(Integer id);
	public void removeAll();
}
