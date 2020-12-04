package com.bootjobs.model;

public interface SocietaUtilities {
	
	public boolean iscrizione(Societa s_isc);
	
	public Societa modificaProfilo(Societa s_mod);
	
	public boolean eliminaProfilo(int id);
	
	public Societa accessoSocieta(String mail, String password);

}
