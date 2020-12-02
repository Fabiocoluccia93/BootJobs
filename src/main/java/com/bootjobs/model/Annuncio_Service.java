package com.bootjobs.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;



public class Annuncio_Service implements Annuncio_utility {
	
	public Annuncio_Service() {
		// TODO Auto-generated constructor stub
	}

	public boolean inserisciAnnuncio(Annuncio a_ins) {
		EntityManager em = Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		
		return false;
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
