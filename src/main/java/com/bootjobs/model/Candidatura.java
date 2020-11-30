package com.bootjobs.model;

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


@Entity
@Table( name = "candidatura" )
public class Candidatura
{
 private Integer id_candidatura;
 private Integer id_candidato;
 private Integer annuncio;
 private Integer id_societa;
 private ArrayList<Candidato> candidato;
 
 public Candidatura()
 {
	super();
	// TODO Auto-generated constructor stub
 }
public Candidatura( Integer id_candidato, Integer annuncio, Integer id_societa) 
{
	super();
	this.id_candidato = id_candidato;
	this.annuncio = annuncio;
	this.id_societa = id_societa;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_candidatura")
public Integer getId() {
	return id_candidatura;
}
public void setId(int Integer) {
	this.id_candidatura = id_candidatura;
}
public int getId_candidato() {
	return id_candidato;
}
public void setId_candidato(Integer id_candidato) {
	this.id_candidato = id_candidato;
}
public int getAnnuncio() {
	return annuncio;
}
public void setAnnuncio(Integer annuncio) {
	this.annuncio = annuncio;
}
public int getId_societa() {
	return id_societa;
}
public void setId_societa(Integer id_societa) {
	this.id_societa = id_societa;
}

@ManyToMany(fetch = FetchType.LAZY, mappedBy = "candidatura")
public ArrayList<Candidato> getCandidato() {
	return candidato;
}
public void setCandidato(ArrayList<Candidato> candidato) {
	this.candidato = candidato;
}
 
}
