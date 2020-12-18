package com.bootjobs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "category")

@NamedQuery(name = "Category", query = "SELECT c FROM Category c")

public class Category {
	@Column(name = "category_name")
	private String category_name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private int id_category;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String category_name) {
		super();
		this.category_name = category_name;
	}

	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

}
