package com.bootjobs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "annuncio")
@NamedQueries({

		@NamedQuery(name = "searchAnnuncio", query = "select e from Annuncio e where e.nome_annuncio like :name"),
		@NamedQuery(name = "searchById", query = "select a from Annuncio a where a.id_societa_annuncio=:p"),
		@NamedQuery(name = "Annuncioedit", query = "update Annuncio a set a.nome_annuncio = :nome , a.descrizione =:desc, a.stipendio = :sti, a.titolo_di_studio = :tito, a.tipo_contratto = :contract, a.comune = :com, a.data_pubblicazione = :date where a.id = :b"),

})

public class Annuncio {

//	private Categoria categoria;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_annuncio")
	private int id;
	@Column(name = "id_societa_annuncio")
	private int id_societa_annuncio;
	@Column(name = "nome_annuncio")
	private String nome_annuncio;
	@Column(name = "titolo_di_studio")
	private String titolo_di_studio;
	@Column(name = "tipo_contratto")
	private String tipo_contratto;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "stipendio")
	private Double stipendio;
	@Column(name = "data_pubblicazione")
	Date data_pubblicazione;
	@Column(name = "comune")
	private String comune;

	public Annuncio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annuncio(

//			Categoria categoria, 
			String nome_annuncio, String titolo_di_studio, String tipo_contratto, String descrizione, Double stipendio,
			int id_societa_annuncio, Date data_pubblicazione) {
		super();

//		this.categoria = categoria;
		this.id_societa_annuncio = id_societa_annuncio;
		this.nome_annuncio = nome_annuncio;
		this.titolo_di_studio = titolo_di_studio;
		this.tipo_contratto = tipo_contratto;
		this.descrizione = descrizione;
		this.stipendio = stipendio;
		this.data_pubblicazione = data_pubblicazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

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

	public int getId_societa_annuncio() {
		return id_societa_annuncio;
	}

	public void setId_societa_annuncio(int id_societa_annuncio) {
		this.id_societa_annuncio = id_societa_annuncio;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

}
