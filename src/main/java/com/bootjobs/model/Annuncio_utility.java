package com.bootjobs.model;

import java.util.List;

public interface Annuncio_utility {

	public List<Annuncio> findById(int id);
	
	public boolean inserisciAnnuncio(Annuncio a_ins);

	public boolean modificaAnnuncio(Annuncio a_mod , int id);

	public boolean eliminaAnnuncio(int id, int id_soc);

	public List<Annuncio> ricercanome_annuncio(String nome);
	
	public List<Annuncio> getTipoContratto();

}
