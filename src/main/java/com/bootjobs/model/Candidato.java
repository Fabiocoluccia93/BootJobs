package com.bootjobs.model;

import java.sql.Date;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "candidato" )
public class Candidato
{
	private Integer id_candidato;
	private String mail;
	private String password;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String titolo_studio;
	private Integer numero_telefono;
	private String comune;
	private ArrayList<Candidatura> candidatura;
	
	
	public Candidato() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidato(String mail, String password, String nome, String cognome, Date data_nascita,
			String titolo_studio, int numero_telefono, String comune) 
	{
		super();
		this.mail = mail;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.titolo_studio = titolo_studio;
		this.numero_telefono = numero_telefono;
		this.comune = comune;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_candidato")
	public Integer getId() {
		return id_candidato;
	}
	public void setId(Integer id) {
		this.id_candidato = id_candidato;
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
	public Integer getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(Integer numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "candidatura", catalog = "bootjobs", joinColumns = { 
//	        @JoinColumn(name = "id", nullable = false, updatable = false) }, 
//	        inverseJoinColumns = { @JoinColumn(name = "id", 
//	                nullable = false, updatable = false) })
	
	public ArrayList<Candidatura> getCandidatura() {
		return candidatura;
	}
	public void setCandidatura(ArrayList<Candidatura> candidatura) {
		this.candidatura = candidatura;
	}
}
