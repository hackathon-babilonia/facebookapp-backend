package com.republicababilonia.homin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.VagaDAO;
import com.republicababilonia.homin.to.VagaTO;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaDAO vagaDAO;
	
	@Transactional
	public void save(VagaTO vaga) {
		vagaDAO.save(vaga);
	}

	@Transactional
	public void remove(Integer id) {
		vagaDAO.remove(id);
	}
	
}
