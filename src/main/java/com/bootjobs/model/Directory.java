package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "directory" )
public class Directory 
{
 private Integer id_posizione;
 private String posizione;
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="id_posizione")
public Integer getId_posizione() {
	return id_posizione;
}
public void setId_posizione(Integer id_posizione) {
	this.id_posizione = id_posizione;
}
public String getPosizione() {
	return posizione;
}
public void setPosizione(String posizione) {
	this.posizione = posizione;
}
public Directory(String posizione) {
	super();
	
	this.posizione = posizione;
}
public Directory() {
	super();
	// TODO Auto-generated constructor stub
}
 
	
}
