package com.bootjobs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table( name = "candidatura" )
@NamedQueries({
@NamedQuery(name="Candidatura.delete", query="DELETE FROM Candidatura  where id_candidatura LIKE :id_candidatura "),
@NamedQuery(name="Candidatura.findall", query="SELECT c FROM Candidatura c where c.id_candidato_fk LIKE :id_candidato_fk "),
@NamedQuery(name="Candidatura.checkannuncio", query="SELECT c FROM Candidatura c WHERE c.id_candidato_fk LIKE :id_candidato AND c.id_annuncio_fk LIKE:id_annuncio"),
@NamedQuery(name="Candidatura.trovacandidatura",query="SELECT c FROM Candidatura c where c.id_candidato_fk=:idcandidato")
})
public class Candidatura
{
 private Integer id;
 private Integer id_candidato_fk;
 private Integer id_annuncio_fk;
 private Integer id_societa_fk;
// private List<Candidato> candidato;
 
 public Candidatura()
 {
	super();
	// TODO Auto-generated constructor stub
 }
public Candidatura( Integer id_candidato_fk, Integer annuncio, Integer id_societa_fk) 
{
	super();
	this.id_candidato_fk = id_candidato_fk;
	this.id_annuncio_fk = annuncio;
	this.id_societa_fk = id_societa_fk;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_candidatura")
public Integer getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Integer getId_candidato_fk() {
	return id_candidato_fk;
}
public void setId_candidato_fk(Integer id_candidato_fk) {
	this.id_candidato_fk = id_candidato_fk;
}
public Integer getId_annuncio_fk() {
	return id_annuncio_fk;
}
public void setId_annuncio_fk(Integer id_annuncio_fk) {
	this.id_annuncio_fk = id_annuncio_fk;
}
public Integer getId_societa_fk() {
	return id_societa_fk;
}
public void setId_societa_fk(Integer id_societa_fk) {
	this.id_societa_fk = id_societa_fk;
}


//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "candidatura")
//public List<Candidato> getCandidato() {
//	return candidato;
//}
//public void setCandidato(List<Candidato> candidato) {
//	this.candidato = candidato;
//}
// 
}
