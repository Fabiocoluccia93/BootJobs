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

@Table(name = "titolo_di_studio")
public class TitoloStudio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_titolo_di_studio")
	private int id_titolo;

	@Column(name = "titolo_di_studio")
	private String tds;

	public TitoloStudio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TitoloStudio(int id_titolo, String tds) {
		super();
		this.id_titolo = id_titolo;
		this.tds = tds;
	}

	public int getId_titolo() {
		return id_titolo;
	}

	public void setId_titolo(int id_titolo) {
		this.id_titolo = id_titolo;
	}

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
	}

}
