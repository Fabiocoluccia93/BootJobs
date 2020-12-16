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
@Table(name = "tipologia")
@SecondaryTable(name="titolo_di_studio", pkJoinColumns=@PrimaryKeyJoinColumn(name="id_titolo_di_studio"))
public class Tipologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipologia")
	private int id_tipologia;

	@Column(name = "tipo_contratto")
	private String tipologia;
	
	@Column(name="titolo_di_studio", table="titolo_di_studio")
	private String tds;

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

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
	}

}
