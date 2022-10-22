package ism.inscription.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.core.Fabrique;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudiantController implements Initializable {
    @FXML
    TextField txtTuteur, txtNomPrenom;
    @FXML
    RadioButton radInscription, radReinscription;
    @FXML
    TableView<Etudiant> tblvEtudiant = new TableView<>();
    @FXML
    TableColumn<Etudiant, String> tblcNom = new TableColumn<>();
    @FXML
    TableColumn<Etudiant, String> tblcTuteur = new TableColumn<>();
    @FXML
    TableColumn<Etudiant, String> tblcId = new TableColumn<>();
    @FXML
    TableColumn<Etudiant, String> tblcMatricule = new TableColumn<>();
    @FXML
    TableColumn<Etudiant, String> tblcClasse = new TableColumn<>();
    @FXML
    ChoiceBox choiceClasse;

    private ObservableList obEtudiants = FXCollections.observableArrayList(Fabrique.getService().ListerEtudiants());
    Etudiant etu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        tblcMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tblcClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));

        choiceClasse.getItems().setAll(Fabrique.getService().listerClasses());
        tblvEtudiant.setItems(obEtudiants);
    }

    public void handleAjouterEtudiant() {
        String nomComplet = txtNomPrenom.getText().trim();
        String tuteur = txtTuteur.getText().trim();
        Classe classe = (Classe) choiceClasse.getValue();

        Etudiant etudiant = new Etudiant(nomComplet, tuteur, classe);
        String matricule = Fabrique.getService().genererMatricule(etudiant);
        etudiant = Fabrique.getService().inscrireEtudiant(new Etudiant(nomComplet, tuteur, matricule, classe));

        obEtudiants.add(etudiant);
        txtNomPrenom.clear();
        txtTuteur.clear();
    }

}
