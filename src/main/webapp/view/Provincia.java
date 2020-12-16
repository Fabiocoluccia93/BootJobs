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
@Table(name = "tbprovince")
@NamedQueries({
	@NamedQuery(name = "getProvince", query = "select a from Provincia a where a.codiceistat_provincia = :p "),
	@NamedQuery(name="getSigla", query="select a from Provincia a where a.nome_provincia = :p")
	
})
// 

public class Provincia {

	/**
	 * 
	 */
	@Id
	@Column(name="sigla_provincia")
	private String sigla;
	
	@Column(name = "nome_provincia")
	private String nome_provincia;
	
	@Column(name="codiceistatregione_provincia")
	private int codiceistat_provincia;

	public String getNome_provincia() {
		return nome_provincia;
	}

	public void setNome_provincia(String nome_provincia) {
		this.nome_provincia = nome_provincia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCodiceistat_provincia() {
		return codiceistat_provincia;
	}

	public void setCodiceistat_provincia(int codiceistat_provincia) {
		this.codiceistat_provincia = codiceistat_provincia;
	}
}
