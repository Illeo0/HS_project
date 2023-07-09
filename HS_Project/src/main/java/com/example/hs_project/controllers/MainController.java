package com.example.hs_project.controllers;

import com.example.hs_project.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button heroSelection;
    @FXML
    private Button bestBuild;
    @FXML
    private Button minionFilter;
    @FXML
    private ChoiceBox<String> tribesAvailable1;
    @FXML
    private ChoiceBox<String> tribesAvailable2;
    @FXML
    private ChoiceBox<String> tribesAvailable3;
    @FXML
    private ChoiceBox<String> tribesAvailable4;
    @FXML
    private ChoiceBox<String> tribesAvailable5;
    private String[] tribes = {"undead", "naga", "quillboar", "murloc", "demon", "elemental", "dragon", "beast", "robot", "pirate"};

    public static String[] selectedTribes = new String[] {"No tribe selected", "No tribe selected", "No tribe selected", "No tribe selected", "No tribe selected"};

    /**
     * This method load the tribe selected into the specified choice-box
     * @param tribeNumber is used as index to select one of the 4 choices
     */
    private void tribeChoice (int tribeNumber) {
        ChoiceBox[] cb = new ChoiceBox[] {tribesAvailable1, tribesAvailable2, tribesAvailable3, tribesAvailable4, tribesAvailable5};
        selectedTribes[tribeNumber] = (String) cb[tribeNumber].getValue();
    }

    private void tribeChoice1 (ActionEvent event) {
        tribeChoice(0);
    }
    private void tribeChoice2 (ActionEvent event) {
        tribeChoice(1);
    }
    private void tribeChoice3 (ActionEvent event) {
        tribeChoice(2);
    }
    private void tribeChoice4 (ActionEvent event) {
        tribeChoice(3);
    }
    private void tribeChoice5 (ActionEvent event) {
        tribeChoice(4);
    }

    /**
     * This method is used to load texts and images before launching the application
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tribesAvailable1.getItems().addAll(tribes);
        tribesAvailable2.getItems().addAll(tribes);
        tribesAvailable3.getItems().addAll(tribes);
        tribesAvailable4.getItems().addAll(tribes);
        tribesAvailable5.getItems().addAll(tribes);
        tribesAvailable1.setOnAction(this::tribeChoice1);
        tribesAvailable2.setOnAction(this::tribeChoice2);
        tribesAvailable3.setOnAction(this::tribeChoice3);
        tribesAvailable4.setOnAction(this::tribeChoice4);
        tribesAvailable5.setOnAction(this::tribeChoice5);
    }

    /**
     This method shows the new stage when the specified button is pressed
     **/
    public static Stage heroSelectionStage = new Stage();
    @FXML
    private void onMouseClickedHeroSelection(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hero_selection.fxml"));
            Scene heroSelectionScene = new Scene(fxmlLoader.load(), 600, 400);
            heroSelectionStage.setTitle("Heroes Selection");
            heroSelectionStage.setScene(heroSelectionScene);
            heroSelectionStage.show();
        }catch (Exception e){
            System.out.print("error");
        }
    }

    /**
     This method shows the new stage when the specified button is pressed
     **/
    @FXML
    private void onMouseClickedBestBuild(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("best_build.fxml"));
            Scene bestBuildScene = new Scene(fxmlLoader.load(), 600, 400);
            Stage bestBuildStage = new Stage();
            bestBuildStage.setTitle("Best Build");
            bestBuildStage.setScene(bestBuildScene);
            bestBuildStage.show();
        }catch (Exception e){
            System.out.print("error");
        }
    }

    /**
     This method shows the new stage when the specified button is pressed
     **/
    @FXML
    private void onMouseClickedMinionFilter(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("minion_filter.fxml"));
            Scene minionFilterScene = new Scene(fxmlLoader.load(), 600, 400);
            Stage minionFilterStage = new Stage();
            minionFilterStage.setTitle("Minion Filter");
            minionFilterStage.setScene(minionFilterScene);
            minionFilterStage.show();
        }catch (Exception e){
            System.out.print(e);
        }
    }
}