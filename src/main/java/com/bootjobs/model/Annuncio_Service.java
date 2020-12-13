package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class Annuncio_Service implements Annuncio_utility {

	EntityManager em = Dao.newInstance().createEntityManager();
	EntityTransaction entr = em.getTransaction();


	public Annuncio findById(Long id) {
		Annuncio a = new Annuncio();
		em.getTransaction().begin();
		a = em.find(Annuncio.class, id);
		return a;
	}

	public Annuncio_Service() {
		// TODO Auto-generated constructor stub
	}

	public boolean inserisciAnnuncio(Annuncio a_ins) {

	
		entr.begin();
		em.persist(a_ins);
		entr.commit();
		em.close();

		return true;
	}

	public Annuncio modificaAnnuncio(String nomeAnnuncio, Annuncio a_mod) {
		
		

		entr.begin();
		Query query = em.createNamedQuery("Annuncio.edit");
		query.setParameter("nome",nomeAnnuncio);
		System.out.println(a_mod.getNome_annuncio());
		query.setParameter("p", a_mod.getNome_annuncio());
		query.executeUpdate();
		entr.commit();
		em.close();

		
		return null;
	}

	public boolean eliminaAnnuncio(int id, int id_soc) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Annuncio> ricercanome_annuncio(String nome) {

		EntityManager em = Dao.newInstance().createEntityManager();

		Query q = em.createNamedQuery("searchAnnuncio");
		
		List<Annuncio> lAnnuncio = new ArrayList<Annuncio>();

		q.setParameter("name", nome);

		lAnnuncio = q.getResultList();

		return lAnnuncio;

	}

	public List<Annuncio> getTipoContratto() {
		

			List<Annuncio> contratti = em.createQuery("Select a. From Annuncio a", Annuncio.class).getResultList();
			return contratti;		
	}



}
