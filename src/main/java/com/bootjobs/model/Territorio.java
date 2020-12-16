package com.bootjobs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbregioni")
@NamedQueries({
	@NamedQuery(name="findCodIstat", query="select c from Territorio c where c.regione = :r")
	
})
public class Territorio {

	@Column(name="nome_regione")
	private String regione;
<<<<<<< HEAD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codiceistat_regione")
	private int id;
=======
//	private String provincia;
//	private String comune;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codiceistat_regione")
	private int id;
//	regione, provinica, 
>>>>>>> branch 'Alessio_F_T' of https://github.com/Fabiocoluccia93/BootJobs.git

	public Territorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Territorio(
<<<<<<< HEAD

=======
			//String comune
//			, String provinica, 
>>>>>>> branch 'Alessio_F_T' of https://github.com/Fabiocoluccia93/BootJobs.git
			int id,
			String regione
			) {
		super();
		this.id = id;
		this.regione = regione;
<<<<<<< HEAD

=======
//		this.provinica = provinica;
//		this.comune = comune;
>>>>>>> branch 'Alessio_F_T' of https://github.com/Fabiocoluccia93/BootJobs.git
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
<<<<<<< HEAD
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
=======
>>>>>>> branch 'Alessio_F_T' of https://github.com/Fabiocoluccia93/BootJobs.git
	}
//
//	public String getProvinica() {
//		return provinica;
//	}
//
//	public void setProvinica(String provinica) {
//		this.provinica = provinica;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getComune() {
//		return comune;
//	}
//
//	public void setComune(String comune) {
//		this.comune = comune;
//	}

}
