package ism.inscription.entities;

import java.util.List;

public class Professeur {
    private int id;
    private String nom;
    private String nci;
    private String grade;
    private List<ClasseProfesseur> classeProfesseurs;

    
    public Professeur(int id, String nom, String nci, String grade) {
        this.id = id;
        this.nom = nom;
        this.nci = nci;
        this.grade = grade;
    }
    public Professeur() {
    }
    public Professeur( String nom, String nci, String grade) {
        this.nom = nom;
        this.nci = nci;
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public List<ClasseProfesseur> getClasseProfesseurs() {
        return classeProfesseurs;
    }
    public void setClasseProfesseurs(List<ClasseProfesseur> classeProfesseurs) {
        this.classeProfesseurs = classeProfesseurs;
    }

}
