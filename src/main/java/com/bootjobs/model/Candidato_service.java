package com.bootjobs.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Candidato;


public class Candidato_service 
{
	  public boolean iscrizione(Candidato c_isc)
	  {
		 
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  session.save(c_isc);
		  System.out.println("Inserted Successfully");
		  session.getTransaction().commit();
		  session.close();
		  sessionFactory.close();
		  boolean check = false;
		  return check;
	  }
	  public Candidato modificaProfilo(Candidato c_mod)
	  {
		  return c_mod;
	  }
	  public boolean eliminaProfilo(int id)
	  {
		  boolean check = false;
		  return check;
	  }
}
