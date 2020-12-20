package com.bootjobs.model;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class Candidato_service 
{
	public boolean mailcheck(String mail)
	{
		EntityManager em= Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		Query mailc = em.createNamedQuery("Candidato.checkmail").setParameter("mail", mail);
		List nummail =  mailc.getResultList();
		em.getTransaction().commit();
		em.close();
		boolean check = false;
		if(nummail.size()>1)
		{
			check= false;
		}
		else
		{
			check=true;
		}
		return check;
				
	}
	  public boolean iscrizione(Candidato c_isc)
	  {
		  boolean check = false;
		  EntityManager em= Dao.newInstance().createEntityManager();
		  em.persist(c_isc);
		  em.getTransaction().begin();
		  em.getTransaction().commit();
		  em.close();
		  check =  true;
		  return check;
	  }
	  public Candidato modificaProfilo(Candidato c_mod)
	  {
		  
		  EntityManager em= Dao.newInstance().createEntityManager();
		  em.getTransaction().begin();
		  Query mod = em.createQuery("UPDATE Candidato  SET data_nascita = :data_nascita ,mail = :mail , nome = :nome , cognome = :cognome , titolo_studio = :titolo_studio , numero_telefono = :numero_telefono , comune_candidato = :comune_candidato WHERE mail LIKE :mail ")
				  .setParameter("mail", c_mod.getMail())
				  .setParameter("nome", c_mod.getNome())
				  .setParameter("cognome",c_mod.getCognome())
				  .setParameter("titolo_studio", c_mod.getTitolo_studio())
				  .setParameter("numero_telefono", c_mod.getNumero_telefono())
				  .setParameter("comune_candidato", c_mod.getComune_candidato())
				  .setParameter("data_nascita", c_mod.getData_nascita())
				  .setParameter("mail", c_mod.getMail());
		  int modded = mod.executeUpdate();
		 		 
		  em.getTransaction().commit();
		  em.close();
		  return c_mod;
	  }
	  public boolean modificaFoto(Candidato c_modfoto)
	  {
//		  System.out.println(c_mod.getMail());
//		  System.out.println(c_mod.getFoto());
		  boolean check = false;
		  EntityManager em= Dao.newInstance().createEntityManager();
		  em.getTransaction().begin();	
		  Query mod = em.createQuery("UPDATE Candidato SET foto = :foto where mail = :mail")
				  .setParameter("foto", c_modfoto.getFoto())
				  .setParameter("mail", c_modfoto.getMail());
		  int modded = mod.executeUpdate();
		  	 
		  em.getTransaction().commit();
		  em.close();
		  if(modded>=1)  
		  {
			  check=true;
		  }	  
		  return check;
		  }
	  
	  public boolean modificaDocumento(Candidato c_moddocument)
	  {
		  boolean check = false;
		  EntityManager em= Dao.newInstance().createEntityManager();
		  em.getTransaction().begin();	
		  Query mod1 = em.createQuery("UPDATE Candidato SET curriculum = :curriculum where mail = :mail")
				  .setParameter("curriculum", c_moddocument.getCurriculum())
				  .setParameter("mail", c_moddocument.getMail());
		  int modded1 = mod1.executeUpdate();
		  	 
		  em.getTransaction().commit();
		  em.close();
		  if(modded1>=1)  
		  {
			  check=true;
		  }	  
		  return check;
	 }
	  
	  public boolean eliminaProfilo(String ide)
	  {
		  boolean check = false;
		  EntityManager em= Dao.newInstance().createEntityManager();
		  em.getTransaction().begin();
		  Integer idei = Integer.parseInt(ide);
		  Candidato  a = em.find(Candidato.class, idei);
		  String eliminafoto= a.getFoto();
		  File f = new File(eliminafoto);
		  f.delete();
		  String eliminadoc = a.getCurriculum();
		  File g = new File(eliminadoc);
		  g.delete();
		  Query delete = em.createNamedQuery("Candidato.delete").setParameter("id_candidato", idei);
		  int deleted = delete.executeUpdate();
		  em.getTransaction().commit();
		  em.close();
		  if(deleted>0)
		  {
			  check = true;
		  }
		  return check;
	  }
	  
	  public Candidato login(Candidato c_login)
	  {
		  Candidato c_oklog = null;
		  EntityManager em= Dao.newInstance().createEntityManager();
		  TypedQuery<Candidato> candidato = em.createNamedQuery("Candidato.findByName",Candidato.class).setParameter("mail", c_login.getMail());
		  List<Candidato> results = candidato.getResultList();
		  
			      for(int i=0;i<results.size();i++)
			      {
			         if(results.get(i).getPassword().equals(c_login.getPassword()))
			         {
			        	 System.out.println("Accesso Eseguito");
			        	 c_oklog=results.get(i);

			        	 System.out.println("id candidato = "+results.get(i).getId_candidato());
			         }
			         
			      }
			      if(c_oklog!=null)
			      {
			    	  return c_oklog;
			      }
			      else
			      {
			    	  return null;
			      }
		
	  }
}
