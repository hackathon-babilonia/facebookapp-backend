package com.republicababilonia.homin.service;

import java.util.List;

import com.republicababilonia.homin.to.LocalTO;

public interface LocalService {
	
	public void save(LocalTO contact);
	public List<LocalTO> getTodosLocais();
	public void remove(Integer id);
	public LocalTO findLocalById(Integer id);
	public List<LocalTO> getLocaisByFilters(String vagatipo, String genero, Double precode, Double precoate, String veiculo, Double distancia);
}
