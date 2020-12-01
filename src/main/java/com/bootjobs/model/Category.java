package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Category {

	private String category_name;

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

}
