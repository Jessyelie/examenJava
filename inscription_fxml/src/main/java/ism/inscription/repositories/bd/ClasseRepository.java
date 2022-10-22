package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Classe;
import ism.inscription.repositories.IClasseRepository;

public class ClasseRepository extends MysqlDb implements IClasseRepository {

    private final String SQL_FIND_ALL = "SELECT * FROM `classe`";
    private final String SQL_INSERT_CLASSE = "INSERT INTO `classe` (`libelle`) VALUES (?)";
    private final String SQL_SELECT_BY_LIBELLE = "SELECT * FROM `classe` WHERE `libelle` LIKE ?";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM `classe` WHERE `id`=?";

    // private final String SQL_CONNECT="SELECT * FROM `user` WHERE `login` LIKE ?
    // AND `password` LIKE ?"
    @Override
    public Classe insert(Classe classe) {

        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_INSERT_CLASSE, PreparedStatement.RETURN_GENERATED_KEYS);
            pS.setString(1, classe.getLibelle());
            pS.executeUpdate();
            ResultSet rs = pS.getGeneratedKeys();
            if (rs.next()) {
                classe.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();

        return classe;
    }

    @Override
    public List<Classe> findAll() {
        List<Classe> classes = new ArrayList<>();
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = pS.executeQuery();
            while (rs.next()) {
                Classe classe = new Classe(rs.getString("libelle"), rs.getInt(
                        "id"));
                classes.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return classes;
    }

    @Override
    public Classe findByLibelle(String libelle) {
        Classe classe = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_SELECT_BY_LIBELLE);
            pS.setString(1, libelle);
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                classe = new Classe(rs.getString("libelle"),
                        rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return classe;
    }

    @Override
    public Classe findById(int id) {
        Classe classe = null;
        this.ouvvrirConnectionBD();
        try {
            pS = conn.prepareStatement(SQL_SELECT_BY_ID);
            pS.setString(1, "id");
            ResultSet rs = pS.executeQuery();
            if (rs.next()) {
                classe = new Classe(rs.getString("libelle"),
                        rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnectionBD();
        return classe;
    }
}
