package com.republicababilonia.homin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.UsuarioDAO;
import com.republicababilonia.homin.to.UsuarioTO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public void save(UsuarioTO usuario) {
		usuarioDAO.save(usuario);
	}


	@Transactional
	public void remove(Integer id) {
		usuarioDAO.remove(id);
	}
	
	@Transactional
	public Boolean existeUsuario(Long uId){
		return usuarioDAO.existeUsuario(uId);
	}
	
	@Transactional
	public UsuarioTO findUsuarioByUId(Long uId) {
		return usuarioDAO.findUsuarioByUId(uId);
	}
}
