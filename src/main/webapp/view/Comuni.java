package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tbcomuni")
@NamedQueries({
	@NamedQuery(name="findComuni", query="select c from Comuni c where c.siglaprovincia_comune = :p")

})
public class Comuni {

	@Column(name="nome_comune")
	private String nome_comune;
	@Column(name="siglaprovincia_comune")
	private String siglaprovincia_comune;
	
	@Id
	@Column(name="id_comune")
	
	private long id_comune;

	public String getNome_comune() {
		return nome_comune;
	}

	public void setNome_comune(String nome_comune) {
		this.nome_comune = nome_comune;
	}

	public String getSiglaprovincia_comune() {
		return siglaprovincia_comune;
	}

	public void setSiglaprovincia_comune(String siglaprovincia_comune) {
		this.siglaprovincia_comune = siglaprovincia_comune;
	}

	public long getId_comune() {
		return id_comune;
	}

	public void setId_comune(long id_comune) {
		this.id_comune = id_comune;
	}
	
}
