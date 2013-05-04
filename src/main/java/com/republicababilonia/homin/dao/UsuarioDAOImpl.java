package com.republicababilonia.homin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.UsuarioTO;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(UsuarioTO usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}


	public void remove(Integer id) {
		LocalTO contact = (LocalTO) sessionFactory.getCurrentSession().load(
				LocalTO.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
	
	public Boolean existeUsuario(Long uId) {

		List l =  sessionFactory.getCurrentSession().createQuery("from UsuarioTO where uid = ?").setLong(0, uId)
				.list();
		
		if(l!=null && !l.isEmpty()){
			return true;
		}
		return false;
	}






}
