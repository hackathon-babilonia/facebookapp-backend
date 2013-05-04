package com.republicababilonia.homin.dao;

import com.republicababilonia.homin.to.VagaTO;

public interface VagaDAO {
	
	public void save(VagaTO vaga);
	public void remove(Integer id);
	public VagaTO findVagaById(Integer id);
}
