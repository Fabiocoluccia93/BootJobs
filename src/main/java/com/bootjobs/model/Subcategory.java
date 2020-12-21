package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "subcategory")

@NamedQuery(name = "Subcategory", query = "SELECT c FROM Subcategory c")

public class Subcategory {
	
	
	@Column(name = "subcategory_name")
	private String subcategory_name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategory")
	private int id_subcategory;
	
	@Column(name = "id_category")
	private int id_category;

	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subcategory(String subcategory_name) {
		super();
		this.subcategory_name = subcategory_name;
	}

	
	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public int getId_subcategory() {
		return id_subcategory;
	}

	public void setId_subcategory(int id_subcategory) {
		this.id_subcategory = id_subcategory;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

}
