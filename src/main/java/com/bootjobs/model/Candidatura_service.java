package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Candidatura_service 
{
	
	public boolean checkCandidatura(Candidatura a)
	{
		EntityManager em= Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		Query query =em.createQuery("Select from Candidatura c where c.id_candidato_fk=:id_candidato and id_annuncio_fk=:id_annuncio").setParameter("id_candidato", a.getId_candidato_fk()).setParameter("id_annuncio", a.getId_annuncio_fk());
		List listacandidature = query.getResultList();
		boolean check = false;
		if(listacandidature.size()>1)
		{
			check= false;
		}
		else
		{
			check=true;
		}
		return check;
	}
	public List<Candidatura> visualizzaCandidature(Integer id_candidato)
	{
		 EntityManager em= Dao.newInstance().createEntityManager();
		 em.getTransaction().begin();
		  TypedQuery<Candidatura> query = em.createNamedQuery("Candidatura.findall",Candidatura.class).setParameter("id_candidato_fk", id_candidato);
		  List<Candidatura> listaCandidature =  query.getResultList();
		  em.getTransaction().commit();
		  em.close();
		  return listaCandidature;
	}
	   public boolean inserisciCandidatura(Candidatura ins)
	   {
		   boolean check = false;
			  EntityManager em= Dao.newInstance().createEntityManager();
			  em.persist(ins);
			  em.getTransaction().begin();
			  em.getTransaction().commit();
			  em.close();
			  check =  true;
			  return check;
	   }
	   public Candidatura modificaCandidatura(Candidatura candidancy)
	   {
		   EntityManager em= Dao.newInstance().createEntityManager();
			  em.merge(candidancy);
			  em.getTransaction().begin();		 
			  em.getTransaction().commit();
			  em.close();
			  return candidancy;
	   }
	   public boolean eliminaCandidatura(String id)
	   {
		   EntityManager em= Dao.newInstance().createEntityManager();
			  em.getTransaction().begin();
			  Integer idei = Integer.parseInt(id);
			  Query delete = em.createNamedQuery("Candidatura.delete").setParameter("id_candidatura", idei);
			  int deleted = delete.executeUpdate();
			  em.getTransaction().commit();
			  em.close();
			  boolean check = false;
			  return check;
	   }
}
