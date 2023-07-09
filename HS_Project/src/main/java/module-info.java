module com.example.hs_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.hs_project to javafx.fxml;
    exports com.example.hs_project;
    exports com.example.hs_project.controllers;
    opens com.example.hs_project.controllers to javafx.fxml;
    exports com.example.hs_project.data;
    opens com.example.hs_project.data to javafx.fxml;
}