package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbregioni")
@NamedQueries({
	@NamedQuery(name="findCodIstat", query="select c from Territorio c where c.regione = :r")
	
})
public class Territorio {

	@Column(name="nome_regione")
	private String regione;
//	private String provincia;
//	private String comune;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codiceistat_regione")
	private int id;
//	regione, provinica, 

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(
			//String comune
//			, String provinica, 
			int id,
			String regione
			) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getComune() {
//		return comune;
//	}
//
//	public void setComune(String comune) {
//		this.comune = comune;
//	}

}
