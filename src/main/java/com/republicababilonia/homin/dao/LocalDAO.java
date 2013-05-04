package com.republicababilonia.homin.dao;

import java.util.List;

import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.VagaTO;

public interface LocalDAO {
	
	public void save(LocalTO local);
	public List<LocalTO> getTodosLocais();
	public void remove(Integer id);
	public LocalTO findLocalById(Integer id);
	public List<LocalTO> getLocaisByFilters(String vagatipo, String genero, Double precode, Double precoate, Double distancia, String faculdade);
}
