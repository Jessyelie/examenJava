package ism.inscription.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;
import ism.inscription.repositories.IProfRepository;

public class ProfRepository extends MysqlDb implements IProfRepository {
    private final String SQL_FIND_ALL = "SELECT * FROM `professeur`";
    private final String SQL_INCERT_PROF = "INSERT INTO `professeur` (`nom`, `nci`, `grade`) VALUES (?,?,?);";
    private final String SQL_FIND_BY_CLASSE = "SELECT * FROM `professeur` WHERE `classe_id` LIKE ?";
    private final String SQL_FIND_BY_ID = "SELECT * FROM `professeur` WHERE `id` = ?";

    @Override
    public Professeur insert(Professeur professeur) {
        this.ouvvrirConnectionBD();

        try {
            pS = conn.prepareStatement(SQL_INCERT_PROF);
            pS.setString(1, professeur.getNom());
            pS.setString(2, professeur.getNci());
            pS.setString(3, professeur.getGrade());
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return professeur;
    }

    @Override
    public Professeur findByClasse(Classe classe) {
        Professeur professeur = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_FIND_BY_CLASSE);
            pS.setString(1, "classe_id");
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                professeur = new Professeur(rs.getString("nom"),
                        rs.getString("nci"),
                        rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return professeur;
    }

    @Override
    public List<Professeur> findAll() {

        List<Professeur> professeurs = new ArrayList<>();
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                Professeur professeur = new Professeur(rs.getString("nci"),
                        rs.getString("nom"),
                        rs.getString("grade"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return professeurs;
    }

    @Override
    public Professeur findById(int id) {
        Professeur professeur = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_FIND_BY_ID);
            pS.setInt(1, id);
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                professeur = new Professeur(rs.getString("nom"),
                        rs.getString("nci"),
                        rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return professeur;
    }

}
