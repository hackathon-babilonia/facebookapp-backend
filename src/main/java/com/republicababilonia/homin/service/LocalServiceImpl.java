package com.republicababilonia.homin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.LocalDAO;
import com.republicababilonia.homin.to.LocalTO;

@Service
public class LocalServiceImpl implements LocalService {

	@Autowired
	private LocalDAO localDAO;
	
	@Transactional
	public void save(LocalTO local) {
		localDAO.save(local);
	}

	@Transactional
	public List<LocalTO> getTodosLocais() {
		return localDAO.getTodosLocais();
	}

	@Transactional
	public void remove(Integer id) {
		localDAO.remove(id);
	}
	
	@Transactional
	public LocalTO findLocalById(Integer id) {
		return localDAO.findLocalById(id);
	}
}
