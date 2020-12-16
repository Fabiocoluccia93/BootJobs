package com.bootjobs.model;

import java.util.List;

public interface Territorio_utility {

	public List<Territorio> get_all_regioni();

	public List<Provincia> get_all_province(int regioni);

	public List<Comuni> get_all_comuni(String provincia);

	public List<Territorio> getOne(String nome);
	
	public List<Provincia> getSiglaPro(String nome_provincia);

}