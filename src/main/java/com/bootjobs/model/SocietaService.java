package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

public class SocietaService implements SocietaUtilities {
	
	
	public boolean iscrizione(Societa s) {
		
		boolean iscritto=false;
		EntityManager em = Dao.newInstance().createEntityManager();
		EntityTransaction emt =em.getTransaction();
		emt.begin();
		em.persist(s);
		emt.commit();
		em.close();
		iscritto=true;
		
		return iscritto;
	}
	
	
	
	

	public boolean modificaProfilo(Societa s) {
		
		boolean modifica = false;
		EntityManager em = Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Societa SET password=: password, nome=: nome ,cognome=: cognome, telefono=: telefono where id=: id");
		query.setParameter("password", s.getPassword());
		query.setParameter("nome", s.getNome());
		query.setParameter("cognome", s.getCognome());
		query.setParameter("telefono", s.getTelefono());	
		query.setParameter("id", s.getId());			
			
		int risultati = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
			
		if (risultati >0) {
			modifica = true;
		}
		
		return modifica;
	}

	

	public boolean eliminaProfilo(int id) {
		
		
		boolean elimina=false;
		EntityManager em= Dao.newInstance().createEntityManager();		
		em.getTransaction().begin();			
		
		Societa s = em.find(Societa.class, id);
		
		if(s!=null) {
			
			em.remove(s);
			elimina=true;
			
		}	
		em.getTransaction().commit();
		return elimina;
	}


	
	
	
	
	
	public Societa accessoSocieta(String mail, String password) {
			
		Societa accesso = null;
		EntityManager em=Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
			TypedQuery<Societa> query = em.createNamedQuery("Societa.accessoSocieta", Societa.class);
			query.setParameter("mail", mail);
			query.setParameter("password", password);
				
		try {
			accesso = query.getSingleResult();			
			em.getTransaction().commit();
			
		} catch (NoResultException e) {
			
		}
		finally {
			em.close();
		}
		
		return accesso;
	}
	
	
	
	
	
	

	public boolean checkEsistente(String mail, String pIva) {
		
		boolean esiste = false;
		EntityManager em=Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
			TypedQuery<Societa> query = em.createNamedQuery("Societa.controlloEsistente", Societa.class);
			query.setParameter("mail", mail);
			query.setParameter("pIva", pIva);

		try {
		
			if(query.getSingleResult()!=null) {
				
				esiste=true;
				
			}	
		} catch (NoResultException  e1) {
			
		}
		catch (NonUniqueResultException e) {
			
		}
		
		em.getTransaction().commit();
		return esiste;
	}
}
