package com.republicababilonia.homin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	
	public LocalTO findLocalById(Integer id) {
		List<LocalTO> locais = (List<LocalTO>) sessionFactory.getCurrentSession().createQuery("from LocalTO where id=?").setInteger(0, id).list();
		
		if(locais != null && !locais.isEmpty()){
			return locais.get(0);
		}
		return null;
	}
	public List<LocalTO> getLocaisByFilters(String vagatipo, String genero, Double precode, Double precoate, String veiculo, Double distancia){
		Criteria query = sessionFactory.getCurrentSession().createCriteria(LocalTO.class);
		query.add(Restrictions.eq("local.tipo", vagatipo));
		query.add(Restrictions.between("preco", precode.toString(), precoate.toString()));
		
		
		return null;
	}
	
}
