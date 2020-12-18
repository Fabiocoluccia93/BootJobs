package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_contratto_tb")
public class Tipologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_contratto")
	private int id_tipologia;

	@Column(name = "tipologia")
	private String tipologia;
	


	public Tipologia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipologia(int id_tipologia, String tipologia) {
		super();
		this.id_tipologia = id_tipologia;
		this.tipologia = tipologia;
	}

	public int getId_tipologia() {
		return id_tipologia;
	}

	public void setId_tipologia(int id_tipologia) {
		this.id_tipologia = id_tipologia;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}


}
