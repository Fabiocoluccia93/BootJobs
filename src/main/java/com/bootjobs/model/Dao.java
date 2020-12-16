package com.bootjobs.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
public class Dao
	{
		private static EntityManagerFactory emf=null;

		private Dao()
			{
				super();
				emf=Persistence.createEntityManagerFactory( "bootjobs" );
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
=======
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
>>>>>>> branch 'Alessio_F_T' of https://github.com/Fabiocoluccia93/BootJobs.git
