package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="societa")
@NamedQueries({
	@NamedQuery (name="Societa.accessoSocieta" ,query="SELECT s FROM Societa s where s.mail = :mail and s.password = :password"),
	@NamedQuery (name="Societa.controlloEsistente" , query = "SELECT s FROM Societa s where s.mail = :mail or s.partitaIva = :pIva"),
	@NamedQuery (name = "Societa.eliminaPerPiva" , query = "SELECT s FROM Societa s where s.partitaIva = :pIva"),
})

public class Societa {
	
	private int id;
	private String mail;
	private String password;
	private String partitaIva;
	private String nome;
	private String cognome;
	private String nomeAzienda;
	private String telefono;
	private String comuneSocieta;
	
	public Societa() {
		super();
	}

	public Societa(String mail, String password, String partitaIva, String nome, String cognome, String nomeAzienda,
			String telefono, String comuneSocieta) {
		super();
		this.mail = mail;
		this.password = password;
		this.partitaIva = partitaIva;
		this.nome = nome;
		this.cognome = cognome;
		this.nomeAzienda = nomeAzienda;
		this.telefono = telefono;
		this.comuneSocieta = comuneSocieta;
	}

	
	@Id
	@Column(name="id_societa")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="p_iva")
	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	@Column(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Column(name="nome_azienda")
	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	@Column(name="telefono_contatto")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="comune_societa")
	public String getComuneSocieta() {
		return comuneSocieta;
	}

	public void setComuneSocieta(String comuneSocieta) {
		this.comuneSocieta = comuneSocieta;
	}
	
	
	
	

}
