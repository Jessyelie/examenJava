package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Classe;
import ism.inscription.entities.ClasseProfesseur;
import ism.inscription.entities.Professeur;
import ism.inscription.repositories.IClasseProfesseurRepository;

public class ClasseProfesseurRepository extends MysqlDb implements IClasseProfesseurRepository {
    public final String SQL_INSERT = "INSERT INTO `classe_professeur` (`classe_id`, `professeur_id`) VALUES (?, ?)";
    public final String SQL_AFFECT_CLASSE = "INSERT INTO `classe_professeur` (`classe_id`, `professeur_id`) VALUES (?, ?);";

    @Override
    public ClasseProfesseur insert(ClasseProfesseur classeProfesseur) {
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pS.setInt(1, classeProfesseur.getClasse().getId());
            pS.setInt(2, classeProfesseur.getProfesseur().getId());
            pS.executeUpdate();
            ResultSet rs = pS.getGeneratedKeys();
            if (rs.next()) {
                classeProfesseur.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();

        return classeProfesseur;
    }

    
    

}
