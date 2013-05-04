package com.republicababilonia.homin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.republicababilonia.homin.to.VagaTO;

@Repository
public class VagaDAOImpl implements VagaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(VagaTO vaga) {
		sessionFactory.getCurrentSession().save(vaga);
	}


	public void remove(Integer id) {
		VagaTO vaga = (VagaTO) sessionFactory.getCurrentSession().load(
				VagaTO.class, id);
		if (null != vaga) {
			sessionFactory.getCurrentSession().delete(vaga);
		}

	}
	
	public VagaTO findVagaById(Integer id) {
		List<VagaTO> vagas = (List<VagaTO>) sessionFactory.getCurrentSession().createQuery("from VagaTO where id=?").setInteger(0, id).list();
		
		if(vagas != null && !vagas.isEmpty()){
			return vagas.get(0);
		}
		return null;
	}
}
