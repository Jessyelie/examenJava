package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.ClasseProfesseur;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;

public interface IEcoleService {
    // --------------------------------------professeur
    public Professeur ajouterProfesseur(Professeur professeur);//

    public List<Professeur> listerProfesseurs();//
    
    public ClasseProfesseur affecterClasseAProfesseur(Professeur professeur, Classe classe);//

    public Professeur filterProfesseurParClasse(Classe classe);

    // --------------------------------------classe

    public Classe ajouterClasse(Classe classe);//

    public List<Classe> listerClasses();//

    public Classe filterClasseParLibelle(String libelle);//

    // --------------------------------------etudiant
    public Etudiant inscrireEtudiant(Etudiant etudiant);//

    public Etudiant affecterClasseAEtudiant(Etudiant etudiant,Classe classe);//

    public List<Etudiant> ListerEtudiants();//

    // --------------------------------------user
    public User seConnecter(String login, String password);

    public List<User> listerUsers();

    // --------------------------------------
    public String genererMatricule(Etudiant etudiant);

}
