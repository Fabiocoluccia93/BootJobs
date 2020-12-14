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

	public boolean modificaAnnuncio(String nomeAnnuncio, Annuncio a_mod) {

		boolean bo = false;
		entr.begin();
		Query query = em.createNamedQuery("Annuncioedit");
		query.setParameter("nome", a_mod.getNome_annuncio());
		System.out.println(a_mod.getNome_annuncio());
		query.setParameter("p", nomeAnnuncio);
		int check = query.executeUpdate();
		entr.commit();
		em.close();

		if(check >= 1) {
			return bo = true;
		}
		return bo;
	}

	public boolean eliminaAnnuncio(int id, int id_soc) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Annuncio> ricercanome_annuncio(String nome) {

		Query q = em.createNamedQuery("searchAnnuncio");
		q.setParameter("name", nome);

		List<Annuncio> lAnnuncio = new ArrayList<Annuncio>();

		entr.begin();

		lAnnuncio = q.getResultList();
		entr.commit();
		em.close();

		return lAnnuncio;

	}

	public List<Annuncio> getTipoContratto() {

		List<Annuncio> contratti = em.createQuery("Select a. From Annuncio a", Annuncio.class).getResultList();
		return contratti;
	}

}
