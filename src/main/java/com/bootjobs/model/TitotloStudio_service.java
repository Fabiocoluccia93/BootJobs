package com.bootjobs.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TitotloStudio_service implements TitoloStudio_utility{
	EntityManager em = Dao.newInstance().createEntityManager();
	EntityTransaction entr = em.getTransaction();



	@Override
	public List<TitoloStudio> getTitoloS() {
		
		List<TitoloStudio> listTit = em.createQuery("Select a From TitoloStudio a", TitoloStudio.class).getResultList();
		return listTit;
	}


}
