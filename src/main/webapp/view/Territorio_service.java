package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Territorio_service implements Territorio_utility {
	EntityManager em = Dao.newInstance().createEntityManager();
	EntityTransaction entr = em.getTransaction();

	public List<Territorio> get_all_regioni() {

		List<Territorio> depts = em.createQuery("Select a From Territorio a", Territorio.class).getResultList();
		return depts;

	}

	@SuppressWarnings("unchecked")
	public List<Territorio> getOne(String nome) {
		
		Query query = em.createNamedQuery("findCodIstat");
		query.setParameter("r", nome);
		
		List<Territorio> codIsta = new ArrayList<Territorio>();
		entr.begin();
		codIsta = query.getResultList();
		entr.commit();
		
		return codIsta;
	}

	@SuppressWarnings("unchecked")
	public List<Provincia> get_all_province(int codRegioni) {

		Query query = em.createNamedQuery("getProvince");
		query.setParameter("p", codRegioni);
		
		List<Provincia> pro = new ArrayList<Provincia>();

		entr.begin();
		pro = query.getResultList();
		entr.commit();
		em.close();

		return pro;
	}

	@SuppressWarnings("unchecked")
	public List<Comuni> get_all_comuni(String provincia) {
		Query query = em.createNamedQuery("findComuni");
		query.setParameter("p", provincia);
		List<Comuni> com = new ArrayList<Comuni>();

		entr.begin();
		com = query.getResultList();
		entr.commit();
		em.close();

		return com;
	}

	@SuppressWarnings("unchecked")
	public List<Provincia> getSiglaPro(String nome_provincia) {
		
		Query query = em.createNamedQuery("getSigla");
		query.setParameter("p", nome_provincia);
		List<Provincia> siglaPro = new ArrayList<Provincia>();
		entr.begin();
		siglaPro =query.getResultList();
		entr.commit();
		
		return siglaPro;
	}

}
