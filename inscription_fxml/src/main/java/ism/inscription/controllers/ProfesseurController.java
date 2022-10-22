package ism.inscription.controllers;

import java.net.URL;

import java.util.ResourceBundle;

import ism.inscription.core.Fabrique;
import ism.inscription.entities.Classe;

import ism.inscription.entities.Grade;
import ism.inscription.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfesseurController implements Initializable {

    @FXML
    TextField txtNCI, txtNomPrenom, txtfiltrerProf;

    @FXML
    TableView<Professeur> tblvProfesseur = new TableView<>();

    @FXML
    TableColumn<Professeur, String> tblcNom, tblcGrade, tblcNci, tblcClasse = new TableColumn<>();

    @FXML
    ChoiceBox<Grade> choiceGrade;

    @FXML
    ChoiceBox<Classe> choiceClasse;
    private ObservableList obProf = FXCollections.observableArrayList(Fabrique.getService().listerProfesseurs());

    Grade grade;
    Classe classe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblcNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tblcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblcClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));

        tblvProfesseur.setItems(obProf);

        choiceClasse.setOnAction(this::selectClasse);
        choiceGrade.setOnAction(this::selectGrade);

        choiceGrade.getItems().setAll(Grade.values());
        choiceClasse.getItems().setAll(Fabrique.getService().listerClasses());

    }

    public void handleAjouterProfesseur() {
        Professeur professeur = new Professeur(txtNomPrenom.getText().trim(), txtNCI.getText().trim(),
                grade.name());

        obProf.add(Fabrique.getService().ajouterProfesseur(professeur));
        txtNCI.clear();
        txtNomPrenom.clear();

    }

    public void handlefiltreProf() {
        obProf.clear();
        /*
         * obProf.add(Fabrique.getService().filterProfesseurParClasse(Fabrique.
         * getService().filterClasseParLibelle(1)));
         */
    }

    public void selectGrade(ActionEvent event) {
        grade = choiceGrade.getValue();
    }

    public void selectClasse(ActionEvent event) {
        classe = choiceClasse.getValue();
    }

}
