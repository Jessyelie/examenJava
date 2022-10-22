package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;

public interface IEtudiantRepository {

    public Etudiant insert(Etudiant etudiant);

    public List<Etudiant> findAll();

    public Etudiant findByClasse(Classe classe);

    public Etudiant findById(int id);

    public String makeMatricule(Etudiant etudiant);

}
