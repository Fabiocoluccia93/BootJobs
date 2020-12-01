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
	
	private Long id, id_societa_annuncio;
	private String nome_annuncio, titolo_di_studio, tipo_contratto, descrizione;
	private Territorio territorio;
	private Categoria categoria;
	private Double stipendio;
	Date data_pubblicazione;

	public Annuncio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annuncio(Long id, Long id_societa_annuncio, String nome_annuncio, String titolo_di_studio,
			String tipo_contratto, String descrizione, Territorio territorio, Categoria categoria, Double stipendio,
			Date data_pubblicazione) {
		super();
		this.id = id;
		this.id_societa_annuncio = id_societa_annuncio;
		this.nome_annuncio = nome_annuncio;
		this.titolo_di_studio = titolo_di_studio;
		this.tipo_contratto = tipo_contratto;
		this.descrizione = descrizione;
		this.territorio = territorio;
		this.categoria = categoria;
		this.stipendio = stipendio;
		this.data_pubblicazione = data_pubblicazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_societa_annuncio() {
		return id_societa_annuncio;
	}

	public void setId_societa_annuncio(Long id_societa_annuncio) {
		this.id_societa_annuncio = id_societa_annuncio;
	}

	public String getNome_annuncio() {
		return nome_annuncio;
	}

	public void setNome_annuncio(String nome_annuncio) {
		this.nome_annuncio = nome_annuncio;
	}

	public String getTitolo_di_studio() {
		return titolo_di_studio;
	}

	public void setTitolo_di_studio(String titolo_di_studio) {
		this.titolo_di_studio = titolo_di_studio;
	}

	public String getTipo_contratto() {
		return tipo_contratto;
	}

	public void setTipo_contratto(String tipo_contratto) {
		this.tipo_contratto = tipo_contratto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getStipendio() {
		return stipendio;
	}

	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}

	public Date getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}



}
