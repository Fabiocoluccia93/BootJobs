package com.bootjobs.model;

import java.util.List;

public interface Annuncio_utility {

	public Annuncio findById(Long id);
	
	public boolean inserisciAnnuncio(Annuncio a_ins);

	public Annuncio modificaAnnuncio(String a, Annuncio a_mod);

	public boolean eliminaAnnuncio(int id, int id_soc);

	public List<Annuncio> ricercanome_annuncio(String nome);
	
	public List<Annuncio> getTipoContratto();

}
