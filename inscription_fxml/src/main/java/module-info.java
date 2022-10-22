module ism.inscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires transitive java.sql;

    opens ism.inscription.controllers to javafx.fxml;

    exports ism.inscription;
    exports ism.inscription.entities;
}
