package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;

public interface IProfRepository {

    public Professeur insert(Professeur professeur);

    public List<Professeur> findAll();

    public Professeur findById(int id);

    public Professeur findByClasse(Classe classe);


}
