package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    @FXML
    AnchorPane anchoreContent;
    @FXML
    Button btnClasse, btnProfesseur, btnEtudiant;

    private void LoadView(String fxml) throws IOException {
        AnchorPane root = (AnchorPane) App.loadFXML(fxml);// il a recuper la partie view agence
        anchoreContent.getChildren().clear();
        anchoreContent.getChildren().add(root);
    }

    public void handleClasse() throws IOException {
        this.LoadView("classe");
    }

    public void handleProfesseur() throws IOException {
        this.LoadView("professeur");
    }

    public void handleEtudiant() throws IOException {
        this.LoadView("etudiant");

    }

    public void handleDeconnexion() throws IOException {
        App.setRoot("connexion");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        if (ConnexionController.user.getRole().name().compareTo("AC") == 0) {

            DisablePermition(false, true, false);
            try {
                this.LoadView("classe");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (ConnexionController.user.getRole().name().compareTo("RP") == 0) {
            DisablePermition(true, false, true);
            try {
                this.LoadView("etudiant");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void DisablePermition(boolean classeBool, boolean etudiantBool, boolean professeurBool) {
        btnClasse.setDisable(classeBool);
        btnEtudiant.setDisable(etudiantBool);
        btnProfesseur.setDisable(professeurBool);
    }

}