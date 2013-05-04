package com.republicababilonia.homin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.PlaceDAO;
import com.republicababilonia.homin.to.PlaceTO;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceDAO placeDAO;
	
	@Transactional
	public void save(PlaceTO place) {
		placeDAO.save(place);
	}

	@Transactional
	public List<PlaceTO> getPlaces(Integer universidade) {
		return placeDAO.getPlaces(universidade);
	}

	@Transactional
	public void remove(Integer id) {
		placeDAO.remove(id);
	}
	
	@Transactional
	public PlaceTO findPlaceById(Integer id) {
		return placeDAO.findPlaceById(id);
	}
	
	@Transactional
	public void removeAll() {
		placeDAO.removeAll();
	}
}
