package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class Territorio_service implements Territorio_utility {

	public List<Territorio> get_all_regioni() {

		EntityManager em = Dao.newInstance().createEntityManager();

		List<Territorio> depts = em.createQuery("Select a From Territorio a", Territorio.class).getResultList();
		return depts;

	}

	public ArrayList<String> get_all(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
