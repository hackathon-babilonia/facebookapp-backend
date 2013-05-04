package com.republicababilonia.homin.service;

import java.util.List;

import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.VagaTO;

public interface LocalService {
	
	public void save(LocalTO contact);
	public List<LocalTO> getTodosLocais();
	public void remove(Integer id);
	public LocalTO findLocalById(Integer id);
	public List<LocalTO> getLocaisByFilters(String vagatipo, String genero,Double precode, Double precoate, Long veiculo, Double tempo, String faculdade);
}
