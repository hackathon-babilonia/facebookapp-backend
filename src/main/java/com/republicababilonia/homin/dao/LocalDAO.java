package com.republicababilonia.homin.dao;

import java.util.List;

import com.republicababilonia.homin.to.LocalTO;

public interface LocalDAO {
	
	public void save(LocalTO local);
	public List<LocalTO> getTodosLocais();
	public void remove(Integer id);
}
