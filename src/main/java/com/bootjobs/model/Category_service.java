package com.bootjobs.model;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


public class Category_service implements Category_utility {
	
	
	public List<Category> queryForCategory() {
		EntityManager em = Dao.newInstance().createEntityManager();
		List<Category> ctg = em.createNamedQuery("Category").getResultList();
		return ctg;	

}

	public ArrayList<String> get_allsubcategory() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<String> get_all_sub(String subcategory_name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

