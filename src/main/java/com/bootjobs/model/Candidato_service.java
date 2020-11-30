package com.bootjobs.model;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class Candidato_service 
{
	  public boolean iscrizione(Candidato c_isc)
	  {
		  boolean check = false;
			SessionFactory sessionFactory=null;
			// A SessionFactory is set up once for an application!
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
			try 
			{
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) 
			{
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				StandardServiceRegistryBuilder.destroy( registry );
			}
		  Session session = sessionFactory.openSession();
		  session.beginTransaction();
		  session.save(c_isc);
		  check =  true;
		  session.getTransaction().commit();
		  session.close();
		  sessionFactory.close();
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
