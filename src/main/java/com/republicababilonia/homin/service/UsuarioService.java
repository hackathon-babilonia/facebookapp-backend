package com.republicababilonia.homin.service;

import com.republicababilonia.homin.to.UsuarioTO;

public interface UsuarioService {
	
	public void save(UsuarioTO usuario);
	public void remove(Integer id);
	public Boolean existeUsuario(Long uId);
	public UsuarioTO findUsuarioByUId(Long uId);
}
