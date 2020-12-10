package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class Annuncio_Service implements Annuncio_utility {

	public Annuncio findById(Long id) {
		EntityManager em = Dao.newInstance().createEntityManager();
		Annuncio a = new Annuncio();
		em.getTransaction().begin();
		a = em.find(Annuncio.class, id);
		return a;
	}

	public Annuncio_Service() {
		// TODO Auto-generated constructor stub
	}

	public boolean inserisciAnnuncio(Annuncio a_ins) {

		EntityManager em = Dao.newInstance().createEntityManager();

		EntityTransaction entr = em.getTransaction();
		entr.begin();
		em.persist(a_ins);
		entr.commit();
		em.close();
		System.out.println(a_ins.getNome_annuncio() + "E' stato inserito correttamente");

		return true;
	}

	public Annuncio modificaAnnuncio(String nomeAnnuncio, Annuncio a_mod) {
		
		EntityManager em = Dao.newInstance().createEntityManager();
		EntityTransaction entr = em.getTransaction();

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

		Query q = em.createNamedQuery("Annuncio.findByName");
		
		List<Annuncio> lAnnuncio = new ArrayList<Annuncio>();

		q.setParameter("name", nome);

		lAnnuncio = q.getResultList();

		return lAnnuncio;

	}



}
