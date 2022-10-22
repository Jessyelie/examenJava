package ism.inscription.entities;

import java.util.List;

public class Classe {
    private String libelle;
    private int id;
    private List<ClasseProfesseur> classeProfesseurs;

    public Classe() {
    }

    public Classe(String libelle, int id) {
        this.libelle = libelle;
        this.id = id;
    }

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    public List<ClasseProfesseur> getClasseProfesseurs() {
        return classeProfesseurs;
    }

    public void setClasseProfesseurs(List<ClasseProfesseur> classeProfesseurs) {
        this.classeProfesseurs = classeProfesseurs;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return libelle;
    }

}
