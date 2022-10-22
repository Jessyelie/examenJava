package ism.inscription.entities;


public class ClasseProfesseur {
    private int id;
    private Classe classe;
    private Professeur professeur;

    public ClasseProfesseur(Classe classe, Professeur professeur) {
        this.classe = classe;
        this.professeur = professeur;
    }

    public ClasseProfesseur() {
    }

    public ClasseProfesseur(int id, Classe classe, Professeur professeur) {
        this.id = id;
        this.classe = classe;
        this.professeur = professeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

}
