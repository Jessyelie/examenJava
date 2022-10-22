package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;

public class EtudiantRepository extends MysqlDb implements IEtudiantRepository {
    private final String SQL_FIND_ALL = "SELECT * FROM `etudiant`";
    private final String SQL_INSERT_ETUDIANT = "INSERT INTO `etudiant` (`nom_complet`, `tuteur`, `matricule`) VALUES (?, ?, ?)";
    private final String SQL_SELECT_BY_CLASSE = "SELECT * FROM `etudiant` WHERE `classe_id` LIKE ?";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM `etudiant` WHERE `id` = ?";

    private IClasseRepository classeRepository;
    Etudiant etudiant;

    public EtudiantRepository(IClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_INSERT_ETUDIANT, PreparedStatement.RETURN_GENERATED_KEYS);
            pS.setString(1, etudiant.getNomComplet());
            pS.setString(2, etudiant.getTuteur());
            pS.setString(3, etudiant.getMatricule());
            // pS.setString(3, etudiant.getClasse());
            pS.executeUpdate();
            ResultSet rs = pS.getGeneratedKeys();
            if (rs.next()) {
                etudiant.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();

        return etudiant;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {

                Etudiant etudiant = new Etudiant(rs.getInt("id"), rs.getString("nom_complet"), rs.getString("tuteur"),
                        rs.getString("matricule"));
                Classe classe = classeRepository.findById(rs.getInt("classe_id"));
                etudiant.setClasse(classe);
                etudiants.add(etudiant);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return etudiants;
    }

    @Override
    public Etudiant findByClasse(Classe classe) {
        Etudiant etudiant = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_SELECT_BY_CLASSE);
            pS.setString(1, "classe_id");
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                etudiant = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom_complet"),
                        rs.getString("tuteur"),
                        rs.getString("matricule"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return etudiant;
    }

    @Override
    public Etudiant findById(int id) {
        Etudiant etudiant = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_SELECT_BY_ID);
            pS.setString(1, "id");
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                etudiant = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom_complet"),
                        rs.getString("tuteur"),
                        rs.getString("matricule"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return etudiant;
    }

    @Override
    public String makeMatricule(Etudiant etudiant) {
        String matricule = insert(etudiant).getMatricule();
        matricule = "ETU_0" + insert(etudiant).getId();
        return matricule;
    }
}
