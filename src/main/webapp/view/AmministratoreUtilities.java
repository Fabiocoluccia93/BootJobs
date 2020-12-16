package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

public interface AmministratoreUtilities {
	
	public boolean cancellaSocieta(String pIva);
	
	public Amministratore accessoAmministratore(String username, String password);
	
	public List findAll();
	
}
