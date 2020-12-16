package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "Category")

@NamedQuery(name = "Category", query = "SELECT category_name, subcategory_name \r\n"
		+ "FROM category\r\n"
		+ "INNER JOIN subcategory USING (id_category);")

public class Category {

	private String category_name;
	private int id_category;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String category_name) {
		super();
		this.category_name = category_name;
	}

	@Column(name = "")
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