package com.bootjobs.model;

import java.util.ArrayList;

public interface SocietaUtilities {
		
		public boolean iscrizione(Societa s_isc);
		
		public boolean modificaProfilo(Societa s_mod);
		
		public boolean eliminaProfilo(int id);
		
		public Societa accessoSocieta(String mail, String password);
		
		public boolean checkEsistente(String mail, String pIva);
		
		public ArrayList dropDownRegioni();

	}

