package com.bootjobs.model;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		System.out.println(a_ins.getNome_annuncio());

		return true;
	}

	public Annuncio modificaAnnuncio(Annuncio a_mod) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminaAnnuncio(int id, int id_soc) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Annuncio> ricercanome_annuncio(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
