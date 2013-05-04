package com.republicababilonia.homin.dao;

import com.republicababilonia.homin.to.UsuarioTO;

public interface UsuarioDAO {
	
	public void save(UsuarioTO local);
	public void remove(Integer id);
	public Boolean existeUsuario(Long uId);
	public UsuarioTO findUsuarioByUId(Long uId);
}
