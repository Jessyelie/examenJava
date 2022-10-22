package ism.inscription.entities;

import java.util.List;

public class Etudiant {

    private int id;
    private String nomComplet;
    private String tuteur;
    private String matricule;
    private List<Inscription> inscriptions;
    private Classe classe;

    public Etudiant(String nomComplet, String tuteur, Classe classe) {
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.classe = classe;
    }

    public Etudiant(int id, String nomComplet, String tuteur, String matricule) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.matricule = matricule;
    }

    public Etudiant(String nomComplet, String tuteur, String matricule, Classe classe) {
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.matricule = matricule;
        this.classe = classe;
    }

    public Etudiant(int id, String nomComplet, String tuteur, String matricule, Classe classe) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.matricule = matricule;
        this.classe = classe;
    }

    public Etudiant(String nomComplet, String tuteur, String matricule, List<Inscription> inscriptions, Classe classe) {
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.matricule = matricule;
        this.inscriptions = inscriptions;
        this.classe = classe;
    }

    public Etudiant(int id, String nomComplet, String tuteur, String matricule, List<Inscription> inscriptions,
            Classe classe) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.matricule = matricule;
        this.inscriptions = inscriptions;
        this.classe = classe;
    }

    public Etudiant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
