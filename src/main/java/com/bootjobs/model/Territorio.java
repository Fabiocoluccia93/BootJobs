package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbregioni")
public class Territorio {

	@Column(name="nome_regione")
	private String regione;
//	private String provincia;
//	private String comune;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codiceistat_regione")
	private Long id;
//	regione, provinica, 

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(
			//String comune
//			, String provinica, 
			String regione
			) {
		super();
		this.regione = regione;
//		this.provinica = provinica;
//		this.comune = comune;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
//
//	public String getProvinica() {
//		return provinica;
//	}
//
//	public void setProvinica(String provinica) {
//		this.provinica = provinica;
//	}

//	public String getComune() {
//		return comune;
//	}
//
//	public void setComune(String comune) {
//		this.comune = comune;
//	}

}
