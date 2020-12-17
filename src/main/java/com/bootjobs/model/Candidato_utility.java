package com.bootjobs.model;

public interface Candidato_utility
{
  public boolean iscrizione(Candidato c_isc);
  public Candidato modificaProfilo(Candidato c_mod);
  public boolean eliminaProfilo(int id);
  public Candidato login(Candidato c_login);
}
