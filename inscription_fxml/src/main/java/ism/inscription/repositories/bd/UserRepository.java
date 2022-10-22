package ism.inscription.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.core.MysqlDb;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.Role;
import ism.inscription.entities.User;
import ism.inscription.repositories.IUserRepository;

public class UserRepository extends MysqlDb implements IUserRepository {

  private final String SQL_CONNECT = "SELECT * FROM `user` WHERE `login` LIKE ? AND `password` LIKE ?";
  private final String SQL_FIND_ALL = "SELECT * FROM `user`";

  // private final String SQL_INSERT="INSERT INTO `user` (`role`, `login`,
  // `password`, `nom_complet`, `tel`) VALUES (?,?,?,?, ?)";
  @Override
  public User findUserByLoginAndPassword(String login, String password) {
    User user = null;
    this.ouvvrirConnectionBD();
    try {
      pS = conn.prepareStatement(SQL_CONNECT);
      pS.setString(1, login);
      pS.setString(2, password);
      ResultSet rs = pS.executeQuery();
      if (rs.next()) {
        user = new User(
            rs.getInt("id"),
            rs.getString("role").compareTo("AC") == 0 ? Role.RP : Role.AC,
            rs.getString("login"),
            rs.getString("password"),
            rs.getString("nom_complet"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.fermerConnectionBD();
    return user;
  }

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    this.ouvvrirConnectionBD();
    try {
      pS = conn.prepareStatement(SQL_FIND_ALL);
      ResultSet rs = pS.executeQuery();
      while (rs.next()) {

        User user = new User(rs.getString("login"), rs.getString("password"),
            rs.getString("role"));
        users.add(user);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.fermerConnectionBD();
    return users;
  }
}
