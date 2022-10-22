package ism.inscription.entities;

import java.sql.Date;

public class Inscription {
    private int id;
    private Date dateInscription;
    private Etudiant etudiant;

    public Inscription() {
    }

    public Inscription(Date dateInscription, Etudiant etudiant) {
        this.dateInscription = dateInscription;
        this.etudiant = etudiant;
    }

    public Inscription(int id, Date dateInscription, Etudiant etudiant) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.etudiant = etudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

}
