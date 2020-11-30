package com.bootjobs.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table( name = "candidatura" )
public class Candidatura
{
 private Long id;
 private Long id_candidato_fk;
 private Long id_annuncio_fk;
 private Long id_societa_fk;
 private ArrayList<Candidato> candidato;
 
 public Candidatura()
 {
	super();
	// TODO Auto-generated constructor stub
 }
public Candidatura( Long id_candidato_fk, Long annuncio, Long id_societa_fk) 
{
	super();
	this.id_candidato_fk = id_candidato_fk;
	this.id_annuncio_fk = annuncio;
	this.id_societa_fk = id_societa_fk;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long getId() {
	return id;
}
public void setId(Long Long) {
	this.id = id;
}
public Long getid_candidato_fk() {
	return id_candidato_fk;
}
public void setid_candidato_fk(Long id_candidato_fk) {
	this.id_candidato_fk = id_candidato_fk;
}
public Long getAnnuncio() {
	return id_annuncio_fk;
}
public void setAnnuncio(Long annuncio) {
	this.id_annuncio_fk = id_annuncio_fk;
}
public Long getid_societa_fk() {
	return id_societa_fk;
}
public void setid_societa_fk(Long id_societa_fk) {
	this.id_societa_fk = id_societa_fk;
}

@ManyToMany(fetch = FetchType.LAZY, mappedBy = "candidatura")
public ArrayList<Candidato> getCandidato() {
	return candidato;
}
public void setCandidato(ArrayList<Candidato> candidato) {
	this.candidato = candidato;
}
 
}