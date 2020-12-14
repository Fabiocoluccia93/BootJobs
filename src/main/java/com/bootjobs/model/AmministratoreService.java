package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class AmministratoreService implements AmministratoreUtilities {

	public Amministratore accessoAmministratore(String username, String password) {
		
		Amministratore accesso = null;
		EntityManager em = Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Amministratore> query = em.createNamedQuery("Amministratore.accessoAmministratore", Amministratore.class);
		query.setParameter("user", username);
		query.setParameter("password", password);
		
		try {
			
			accesso = query.getSingleResult();
			
		} catch (NoResultException e) {
	
		}
		
		return accesso;
	}

	
	
	
	
	
	public boolean cancellaSocieta(String pIva) {
	
		boolean eliminato = false;
		EntityManager em = Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
		try {
			Societa s = em.createNamedQuery("Societa.eliminaPerPiva", Societa.class).setParameter("pIva", pIva).getSingleResult();
			
			if(s!=null) {

				em.remove(s);
				eliminato=true;
				
			}
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		em.getTransaction().commit();
		return eliminato;
		
	}






	public List findAll() {
		
		List<Societa> societa = new ArrayList<Societa>();
		Societa s = null;
		
		EntityManager em = Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		s=em.find(Societa.class, 1);
		societa=em.createQuery("from Societa", Societa.class).getResultList();

		
		em.getTransaction().commit();
		em.close();
		
		return societa;
	}
	
	
	

}
