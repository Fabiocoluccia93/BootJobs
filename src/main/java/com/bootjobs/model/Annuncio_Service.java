package com.bootjobs.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Annuncio_Service implements Annuncio_utility {

	ResultSet r = null;
	Statement st = null;
	Connection con = null;
	
	public Annuncio_Service() {
		// TODO Auto-generated constructor stub
	}

	public boolean inserisciAnnuncio(Annuncio a_ins) {
		// TODO Auto-generated method stub
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
