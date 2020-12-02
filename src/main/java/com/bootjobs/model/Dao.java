package com.bootjobs.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	
	private static EntityManagerFactory emf=null;

	private Dao()
		{
			super();
			emf=Persistence.createEntityManagerFactory( "ciccio" );
		}
	
	public static EntityManagerFactory newInstance()
	{
		if(emf==null)
			{
				new Dao();
			}
		return emf;
	}
}
