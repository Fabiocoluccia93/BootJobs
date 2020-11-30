package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table( name = "societa" )
public class Societa {
	
	private int id;
	private String mail;
	private String nome;
	private String cognome;
	private String nome_azienda;
	private String telefono_contatto;
	
	public Societa() {
		super();
	}

	public Societa(String mail, String nome, String cognome, String nome_azienda, String telefono_contatto) {
		super();
		this.mail = mail;
		this.nome = nome;
		this.cognome = cognome;
		this.nome_azienda = nome_azienda;
		this.telefono_contatto = telefono_contatto;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cognome")
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Column(name = "nome_azienda")
	public String getNome_azienda() {
		return nome_azienda;
	}

	public void setNome_azienda(String nome_azienda) {
		this.nome_azienda = nome_azienda;
	}

	@Column(name = "telefono_contatto")
	public String getTelefono_contatto() {
		return telefono_contatto;
	}

	public void setTelefono_contatto(String telefono_contatto) {
		this.telefono_contatto = telefono_contatto;
	}

	
	
	
	
}
