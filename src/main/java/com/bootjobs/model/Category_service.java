package com.bootjobs.model;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


public class Category_service implements Category_utility {
	
	
	
	
	public ArrayList<String> get_all_category() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> get_all(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Category> queryForCategory() {
		EntityManager em = Dao.newInstance().createEntityManager();
		List<Category> ctg = em.createNamedQuery("Category").getResultList();
		return ctg;	

}
	

}

