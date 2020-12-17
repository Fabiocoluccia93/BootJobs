package com.bootjobs.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
@Table( name = "candidato" )
@NamedQueries(
{//id AS id_candidato 
@NamedQuery(name="Candidato.findByName", query="SELECT c FROM Candidato c where c.mail LIKE :mail "),
@NamedQuery(name="Candidato.id", query="SELECT id AS id_candidato FROM Candidato c where c.mail LIKE :mail "),
@NamedQuery(name="Candidato.delete", query="DELETE FROM Candidato  where id_candidato LIKE :id_candidato "),
@NamedQuery(name="Candidato.checkmail", query="SELECT c FROM Candidato c where c.mail LIKE :mail ")
})

public class Candidato
{
	
	private Integer id_candidato;
	private String mail;
	private String password;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String titolo_studio;
	private String numero_telefono;
	private String comune_candidato;
	private String foto;
	private String curriculum;
//	private List<Candidatura> candidatura;
	
	
	public Candidato() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidato(String mail, String password, String nome, String cognome, Date data_nascita,
			String titolo_studio, String numero_telefono, String comune_candidato, String foto, String curriculum) 
	{
		super();
		this.mail = mail;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.titolo_studio = titolo_studio;
		this.numero_telefono = numero_telefono;
		this.comune_candidato = comune_candidato;
		this.foto=foto;
		this.curriculum=curriculum;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_candidato")
	public Integer getId_candidato() {
		return id_candidato;
	}



	public void setId_candidato(Integer id_candidato) {
		this.id_candidato = id_candidato;
	}



	public String getComune_candidato() {
		return comune_candidato;
	}



	public void setComune_candidato(String comune_candidato) {
		this.comune_candidato = comune_candidato;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_nascita")
	public Date getData_nascita() {
		return data_nascita;
	}
	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}
	public String getTitolo_studio() {
		return titolo_studio;
	}
	public void setTitolo_studio(String titolo_studio) {
		this.titolo_studio = titolo_studio;
	}
	public String getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "candidatura", catalog = "bootjobs", joinColumns = { 
//		@JoinColumn(name = "id_candidatura" )}, 
//	    inverseJoinColumns = { @JoinColumn(name = "id_candidato") })
//	public List<Candidatura> getCandidatura() {
//		return candidatura;
//	}
//	public void setCandidatura(List<Candidatura> candidatura) {
//		this.candidatura = candidatura;
//	}
}