package com.republicababilonia.homin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.republicababilonia.homin.to.PlaceTO;
import com.republicababilonia.homin.utils.Constantes;

@Repository
public class PlaceDAOImpl implements PlaceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(PlaceTO place) {
		sessionFactory.getCurrentSession().save(place);
	}

	public List<PlaceTO> getPlaces(Integer universidade) {

		return sessionFactory.getCurrentSession().createQuery("from PlaceTO where universidade = ? and tipo != ?")
				.setInteger(0, universidade)
				.setInteger(1, Constantes.TIPO_INDEFINIDO)
				.list();
	}
	
	public void remove(Integer id) {
		PlaceTO place = (PlaceTO) sessionFactory.getCurrentSession().load(
				PlaceTO.class, id);
		if (null != place) {
			sessionFactory.getCurrentSession().delete(place);
		}

	}
	
	public void removeAll() {
		sessionFactory.getCurrentSession().createQuery("delete from PlaceTO").executeUpdate();
	}
}
