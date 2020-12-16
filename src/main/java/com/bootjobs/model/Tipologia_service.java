package com.bootjobs.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Tipologia_service implements Tipologia_utility {
	EntityManager em = Dao.newInstance().createEntityManager();
	EntityTransaction entr = em.getTransaction();

	public List<Tipologia> getTipologia() {
		
		List<Tipologia> listTip = em.createQuery("Select a From Tipologia a", Tipologia.class).getResultList();
		return listTip;
		
	}

	@Override
	public List<Tipologia> getTitoloS() {
		List<Tipologia> listTit = em.createQuery("Select a From Tipologia a", Tipologia.class).getResultList();
		return listTit;
	}

}
