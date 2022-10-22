package ism.inscription.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.core.Fabrique;
import ism.inscription.entities.Classe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClasseController implements Initializable {
    @FXML
    TableView<Classe> tblvClasse = new TableView<>();
    @FXML
    TableColumn<Classe, String> tblcId = new TableColumn<>();
    @FXML
    TableColumn<Classe, String> tblcLibelle = new TableColumn<>();
    @FXML
    TextField txtNouveauLibelle, txtfiltrerClasse;

    private ObservableList obClasses = FXCollections.observableArrayList(Fabrique.getService().listerClasses());

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblvClasse.setItems(obClasses);
    }

    public void handleAjouterClasse() {
        Classe classe = Fabrique.getService().ajouterClasse(new Classe(txtNouveauLibelle.getText().toString()));
        obClasses.add(classe);
        txtNouveauLibelle.clear();
    }

    public void handlefiltreClasse() {
        String libelle = txtfiltrerClasse.getText().trim();
        obClasses.clear();
        if (libelle.compareTo("") == 0) {
            obClasses.addAll(Fabrique.getService().listerClasses());
        } else {
            obClasses.add(Fabrique.getService().filterClasseParLibelle(libelle));
        }
        txtfiltrerClasse.clear();

    }
}