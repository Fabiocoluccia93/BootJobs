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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codiceistat_regione")
	private int id;

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(

			int id,
			String regione
			) {
		super();
		this.id = id;
		this.regione = regione;

	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
