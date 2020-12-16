package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="amministratore")
@NamedQueries({
	@NamedQuery(name = "Amministratore.accessoAmministratore", query = "SELECT a FROM Amministratore a where a.username = :user and a.password = :password")
})
public class Amministratore {
	
	private int id;
	private String username;
	private String password;
	
	
	public Amministratore() {
		super();
	}


	public Amministratore(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

@Id
@Column(name="id_amministratore")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

@Column(name="username")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

@Column(name="password")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
