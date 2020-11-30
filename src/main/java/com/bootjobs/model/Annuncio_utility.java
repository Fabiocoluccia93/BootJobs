package com.bootjobs.model;

import java.util.ArrayList;

public interface Annuncio_utility {

	public boolean inserisciAnnuncio(Annuncio a_ins);

	public Annuncio modificaAnnuncio(Annuncio a_mod);

	public boolean eliminaAnnuncio(int id, int id_soc);

	public ArrayList<Annuncio> ricercanome_annuncio(String nome);
}
