package com.example.hs_project;

import com.example.hs_project.data.DataManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class starts the entire program using a start method and loading all the data
 * using the DataManagement class
 */
public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("index.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("HS Tracker");
        stage.setScene(mainScene);
        stage.show();
    }
    private static DataManagement dataManagement;

    public static void main(String[] args) {
        dataManagement = new DataManagement();
        dataManagement.loadData();
        launch();
    }
    public static DataManagement getDataManagement() {
        return dataManagement;
    }
}