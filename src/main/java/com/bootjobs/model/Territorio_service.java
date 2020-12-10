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

	public ArrayList<String> get_all(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Provincia> get_all_province() {

		Query query = em.createNamedQuery("getProvince");
		//query.setParameter("", "");
		List<Provincia> pro = new ArrayList<Provincia>();

		entr.begin();
		pro = query.getResultList();
		entr.commit();
		em.close();

		return pro;
	}

	@SuppressWarnings("unchecked")
	public List<Comuni> get_all_comuni() {
		Query query = em.createNamedQuery("findiComuni");
		//query.setParameter("p", "");
		List<Comuni> com = new ArrayList<Comuni>();

		entr.begin();
		com = query.getResultList();
		entr.commit();
		em.close();

		return com;
	}

}
