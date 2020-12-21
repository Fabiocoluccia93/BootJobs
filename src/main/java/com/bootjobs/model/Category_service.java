package com.bootjobs.model;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


public class Category_service implements Category_utility {
	
	
	@SuppressWarnings("unchecked")
	public List<Category> queryForCategory() {
		EntityManager em = Dao.newInstance().createEntityManager();
		List<Category> ctg = em.createNamedQuery("Category").getResultList();
		return ctg;	

}
//	ora devi fare la query 
	@SuppressWarnings("unchecked")
	public List<Subcategory> get_allsubcategory(int id_category) {
		EntityManager em = Dao.newInstance().createEntityManager();
		List<Subcategory> ctg = em.createNamedQuery("Subcategory").
		setParameter("a", id_category )
		.getResultList();
		return ctg;	
	}


}

