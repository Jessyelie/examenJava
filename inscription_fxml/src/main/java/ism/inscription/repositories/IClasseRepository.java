package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;

public interface IClasseRepository {

    public Classe insert(Classe classe);

    public List<Classe> findAll();

    public Classe findByLibelle(String libelle);

    public Classe findById(int id);

}
