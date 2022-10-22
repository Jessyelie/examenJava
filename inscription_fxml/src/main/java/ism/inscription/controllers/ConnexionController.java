package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.core.Fabrique;
import ism.inscription.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {
    @FXML
    TextField txtLogin, txtPassword;
    @FXML
    Text lblError;
    public static User user;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblError.setVisible(false);
    }

    public void handleConnexion() throws IOException {

        String login = txtLogin.getText().trim();
        String password = txtPassword.getText().trim();
        user = Fabrique.getService().seConnecter(login, password);
        if (user != null) {
            App.setRoot("home");
        } else {
            lblError.setVisible(true);
        }

    }
}
