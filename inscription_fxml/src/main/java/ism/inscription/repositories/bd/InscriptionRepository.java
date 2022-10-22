package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Inscription;
import ism.inscription.repositories.IInscriptionRepository;

public class InscriptionRepository extends MysqlDb implements IInscriptionRepository {
    private final String SQL_INSERT = "INSERT INTO `inscription` (`date_inscription`,`etudiant_id`) VALUES (?,?)";

    @Override
    public Inscription insert(Inscription inscription) {
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pS.setDate(1, inscription.getDateInscription());
            pS.setInt(2, inscription.getEtudiant().getId());
            pS.executeUpdate();
            ResultSet rs = pS.getGeneratedKeys();
            if (rs.next()) {
                inscription.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return inscription;
    }

}
