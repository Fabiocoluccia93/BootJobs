package com.bootjobs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "")
public class Annuncio {
	
	private int id, id_societa;
	private String nome_annuncio, titolo_di_studio, tipo_contratto, descrizione, categoria, sottocategoria;
	private Double stipendio;
	Date data_pubblicazione;

	public Annuncio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annuncio(int id, int id_societa, String nome_annuncio, String titolo_di_studio, String tipo_contratto,
			String descrizione, String categoria, String sottocategoria, Double stipendio, Date data_pubblicazione) {
		super();
		this.id = id;
		this.id_societa = id_societa;
		this.nome_annuncio = nome_annuncio;
		this.titolo_di_studio = titolo_di_studio;
		this.tipo_contratto = tipo_contratto;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.sottocategoria = sottocategoria;
		this.stipendio = stipendio;
		this.data_pubblicazione = data_pubblicazione;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "")
	public int getId_societa() {
		return id_societa;
	}

	public void setId_societa(int id_societa) {
		this.id_societa = id_societa;
	}

	@Column(name = "")
	public String getNome_annuncio() {
		return nome_annuncio;
	}

	public void setNome_annuncio(String nome_annuncio) {
		this.nome_annuncio = nome_annuncio;
	}

	@Column(name = "")
	public String getTitolo_di_studio() {
		return titolo_di_studio;
	}

	public void setTitolo_di_studio(String titolo_di_studio) {
		this.titolo_di_studio = titolo_di_studio;
	}

	@Column(name = "")
	public String getTipo_contratto() {
		return tipo_contratto;
	}

	public void setTipo_contratto(String tipo_contratto) {
		this.tipo_contratto = tipo_contratto;
	}

	@Column(name = "")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name = "")
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Column(name = "")
	public String getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(String sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	@Column(name = "")
	public Double getStipendio() {
		return stipendio;
	}

	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "")
	public Date getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}

}
