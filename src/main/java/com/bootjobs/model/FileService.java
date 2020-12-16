package com.bootjobs.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import com.bootjobs.controller.Candidato_controller;

public class FileService 
{
	private static  String destination ;
	private static  String destination1 ;
	public static void  setDirectory()
	{
		EntityManager em= Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		Query a = em.createQuery("Select c.posizione from Directory c where id=1");
		String c = (String) a.getSingleResult();
		Query b = em.createQuery("Select c.posizione from Directory c where id=2");
		String d = (String) b.getSingleResult();
		em.getTransaction().commit();
		em.close();
		FileService.destination=c;
		FileService.destination1=d;	
	}
	public static void setupDirectoryImmagini(String posizione1)
	{
		EntityManager em= Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		Query a = em.createQuery("Update Directory c Set c.posizione = :posizione where id=1").setParameter("posizione", posizione1); 
		a.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	public static void setupDirectoryDocumenti(String posizione2)
	{
		EntityManager em= Dao.newInstance().createEntityManager();
		em.getTransaction().begin();
		Query a = em.createQuery("Update Directory c Set c.posizione = :posizione where id=2").setParameter("posizione", posizione2);
		a.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	public static void setDestinazione(final String destinazione)	
	{
		FileService.destination=destinazione;
	}
	public static void setDestinazione1(final String destinazione1)	
	{
		FileService.destination1=destinazione1;
	}
	public String getFileName(String name) 
	{
		String filename = name + ".jpg";
		return filename;
	}
	public String getFileName1(String name) 
	{
		String filename = name + ".pdf";
		return filename;
	}
	public String UploadFoto(Part filePart, String fileName) throws IOException
	{
		String path = destination;
		OutputStream out = null;
	    InputStream filecontent = null;


	    String dst=""+path+File.separator+fileName+"";
	    try {
	    	
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }

	    }
	    catch (FileNotFoundException fne) 
	    {
	    	
	    } 
	    finally 
	    {
	        if (out != null) 
	        {
	            out.close();
	        }
	        if (filecontent != null)
	        {
	            filecontent.close();
	        }

	    }
	    return dst;
	}
	public String UploadDocument(Part filePart, String fileName) throws IOException
	{
		String path1 = destination1;
		OutputStream out1 = null;
		InputStream filecontent1 = null;

		   String dst1=""+path1+File.separator+fileName+"";
		    try {
		    	
		        out1 = new FileOutputStream(new File(path1 + File.separator
		                + fileName));
		        filecontent1 = filePart.getInputStream();

		        int read1 = 0;
		        final byte[] bytes1 = new byte[1024];

		        while ((read1 = filecontent1.read(bytes1)) != -1) {
		            out1.write(bytes1, 0, read1);
		        }

		    }
		    catch (FileNotFoundException fne) 
		    {
		    	
		    } 
		    finally 
		    {
		        if (out1 != null) 
		        {
		            out1.close();
		        }
		        if (filecontent1 != null)
		        {
		            filecontent1.close();
		        }

		    }
		    return dst1;
	}
}
