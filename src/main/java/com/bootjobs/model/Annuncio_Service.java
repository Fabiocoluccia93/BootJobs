package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Annuncio_Service implements Annuncio_utility {

	EntityManager em = Dao.newInstance().createEntityManager();
	EntityTransaction entr = em.getTransaction();

	@SuppressWarnings("unchecked")
	public Annuncio findById(int id)
	{
		entr.begin();
		Annuncio a = em.find(Annuncio.class, id);
		entr.commit();
		em.close();
		return a;
//		List<Annuncio> a = new ArrayList<Annuncio>();
//		Query q = em.createNamedQuery("searchById").setParameter("p", id);
//		
//		entr.begin();
//		a= q.getResultList();
//		entr.commit();
//		em.close();
//		
//		return a;
	}

	public Annuncio_Service() {
		// TODO Auto-generated constructor stub
	}

	public boolean inserisciAnnuncio(Annuncio a_ins) {

		entr.begin();
		em.persist(a_ins);
		entr.commit();
		

		return true;
	}

	public boolean modificaAnnuncio(Annuncio a_mod, int id) {

		boolean bo = false;
		entr.begin();
		Query query = em.createNamedQuery("Annuncioedit");
		query.setParameter("nome", a_mod.getNome_annuncio())
		.setParameter("desc", a_mod.getDescrizione())
		.setParameter("sti", a_mod.getStipendio())
		.setParameter("tito", a_mod.getTitolo_di_studio())
		.setParameter("contract", a_mod.getTipo_contratto())
		.setParameter("com", a_mod.getComune())
		.setParameter("date", a_mod.getData_pubblicazione())
		.setParameter("b", id);
		//aggiungere il set della categoria e sotto
		int check = query.executeUpdate();
		entr.commit();
		

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
		q.setParameter("name", "%"+ nome +"%");

		List<Annuncio> lAnnuncio = new ArrayList<Annuncio>();

		entr.begin();

		lAnnuncio = q.getResultList();
		entr.commit();
		

		return lAnnuncio;

	}

	public List<Annuncio> getTipoContratto() {

		List<Annuncio> contratti = em.createQuery("Select a. From Annuncio a", Annuncio.class).getResultList();
		return contratti;
	}

}
