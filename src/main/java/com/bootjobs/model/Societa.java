package com.bootjobs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "societa" )

@NamedQueries ( {
	@NamedQuery( name="Societa.accessoSocieta" , query="SELECT s FROM societa s where s.mail=:mail and s.password=:password"),

//	@NamedQuery(name="controlloMail" , query="SELECT s FROM societa s where s.mail=:1 or s.p_iva=:2"),
}
)

public class Societa {
	
	private int id;
	private String mail;
	private String password;
	private String pIva;
	private String nome;
	private String cognome;
	private String nome_azienda;
	private String telefono_contatto;
	private String comuneSocieta;
	




	public Societa() {
		super();
	}


	public Societa(String mail, String password, String pIva, String nome, String cognome, String nome_azienda,
			String telefono_contatto, String comuneSocieta) {
		super();
		this.mail = mail;
		this.password = password;
		this.pIva = pIva;
		this.nome = nome;
		this.cognome = cognome;
		this.nome_azienda = nome_azienda;
		this.telefono_contatto = telefono_contatto;
		this.comuneSocieta = comuneSocieta;
	}







	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_societa")
//	@OneToMany
//	@JoinColumn (name = "id_societa_annuncio", referencedColumnName = "id")
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

	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name="p_iva")
	public String getpIva() {
		return pIva;
	}
	
	public void setpIva(String pIva) {
		
		if(pIva.length() == 11) {
			this.pIva = pIva;			
		}
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

	
	
	@Column(name="comune_societa")
	public String getComuneSocieta() {
		return comuneSocieta;
	}

	
	public void setComuneSocieta(String comuneSocieta) {
		this.comuneSocieta = comuneSocieta;
	}
	
	
	
}
