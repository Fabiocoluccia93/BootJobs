package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Territorio {

	private String nome;

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(String nome) {
		super();
		this.nome = nome;
	}

	@Column(name = "")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
