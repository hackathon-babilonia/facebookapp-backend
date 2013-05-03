package com.republicababilonia.homin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.republicababilonia.homin.to.LocalTO;

@Repository
public class LocalDAOImpl implements LocalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(LocalTO local) {
		sessionFactory.getCurrentSession().save(local);
	}

	public List<LocalTO> getTodosLocais() {

		return sessionFactory.getCurrentSession().createQuery("from LocalTO")
				.list();
	}

	public void remove(Integer id) {
		LocalTO contact = (LocalTO) sessionFactory.getCurrentSession().load(
				LocalTO.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
}
