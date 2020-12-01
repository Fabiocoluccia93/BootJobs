package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Territorio {

	private String regione, provinica, comune;

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(String regione, String provinica, String comune) {
		super();
		this.regione = regione;
		this.provinica = provinica;
		this.comune = comune;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getProvinica() {
		return provinica;
	}

	public void setProvinica(String provinica) {
		this.provinica = provinica;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

}
